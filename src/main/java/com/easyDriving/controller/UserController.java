package com.easyDriving.controller;

import com.easyDriving.pojo.User;
import com.easyDriving.service.UserService;
import com.easyDriving.utils.MailSend;
import com.easyDriving.utils.Md5;
import com.easyDriving.utils.VerifyCodeUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

/**
 * Created by hexing on 15-12-15.
 */

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("")
    public String getRegister(){

        return "register";
    }

    @RequestMapping(value = "regist",method = RequestMethod.POST)
    public @ResponseBody JSONObject doRegist(@RequestParam String u_email,@RequestParam String u_name,@RequestParam String u_password) throws IOException {
        JSONObject jsonObject = new JSONObject();
        if (userService.emailIsEqual(u_email)!=0){
            jsonObject.put("result", "email");
            System.out.println(jsonObject.toString());
            return jsonObject;
        }
        if(userService.nameIsEqual(u_name)!=0) {
            jsonObject.put("result","name");
            System.out.println(jsonObject.toString());
            return jsonObject;
        }
        Random random = new Random();
        String str = String.valueOf(random.nextInt());
        str = Md5.getMd5(str);
        User user = new User();
        user.setU_flag("0");
        user.setU_state("0");
        user.setU_email(u_email);
        user.setU_name(u_name);
        user.setU_password(u_password);
        user.setU_acticode(str);
        userService.insertUser(user);
        jsonObject.put("result", "success");
        MailSend.SendMail(u_email,u_name,str);
        System.out.println(jsonObject.toString());
        return jsonObject;
    }

    //注册邮箱验证
    @RequestMapping("vefiryemail")
    public @ResponseBody JSONObject doValidate(@RequestParam String name,@RequestParam String acticode) throws IOException {
        JSONObject jsonObject = new JSONObject();
        String u_acticode = userService.getActicode(name);
        if (u_acticode.equals(acticode)){
            userService.modifyState();
            jsonObject.put("result","success");
        }else {
            jsonObject.put("result","fail");
        }
        System.out.println(jsonObject.toString());
        return jsonObject;
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public @ResponseBody JSONObject doLogin(@RequestParam String u_email,@RequestParam String u_password,HttpSession session) throws IOException {
        JSONObject jsonObject = new JSONObject();
        if(userService.doLogin(u_email,u_password)==1){
            session.setAttribute("u_flag","on");
            session.setAttribute("u_email",u_email);
            session.setAttribute("u_name","noname");
            jsonObject.put("result", "success");
        }else {
            jsonObject.put("result","fail");
        }
        System.out.println(jsonObject.toString());

        return jsonObject;
    }

    //生成验证码
    @RequestMapping("verifycode")
    public void getVerifyCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        //生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        //存入会话session
        HttpSession session = request.getSession(true);
        session.setAttribute("rand", verifyCode.toLowerCase());
        //生成图片
        int w = 200, h = 80;
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);

    }

    @RequestMapping(value = "forgetpassword",method = RequestMethod.POST)
    public @ResponseBody JSONObject forgetPassword(HttpSession session,@RequestParam String u_email) throws IOException {
        JSONObject jsonObject = new JSONObject();
        if (userService.exitEmail(u_email)==0){
            jsonObject.put("result","fail");
        }else {
            jsonObject.put("result","success");
            session.setAttribute("u_email",u_email);
            Random random = new Random();
            String str = String.valueOf(random.nextInt());
            str = Md5.getMd5(str);
            MailSend.SendMail(u_email, str);
            userService.setFacticode(u_email,str);
        }
        System.out.println(jsonObject);
        return jsonObject;
    }

    @RequestMapping("verifyfpassword")
    public @ResponseBody JSONObject verifyFpassword(@RequestParam String u_email,@RequestParam String u_facticode) throws IOException {
        JSONObject jsonObject = new JSONObject();
        String fcticode = userService.getFacticode(u_email);
        if (fcticode.equals(u_facticode)){
            userService.modifyForget();
            jsonObject.put("result","success");
        }else {
            jsonObject.put("result","fail");
        }
        System.out.println(jsonObject);

        return jsonObject;
    }

    @RequestMapping("setpassword")
    public @ResponseBody JSONObject setPassword(HttpServletRequest request,@RequestParam String u_password) throws IOException {
        JSONObject jsonObject = new JSONObject();
        String u_email = (String) request.getSession().getAttribute("u_email");
        userService.setPassword(u_email,u_password);
        jsonObject.put("result","success");

        return jsonObject;
    }

    @RequestMapping(value = "getuserinfo",method = RequestMethod.POST)
    public @ResponseBody JSONObject getUserInfo(){
        JSONObject jsonObject = new JSONObject();

        return jsonObject;
    }

}
