package com.easyDriving.controller;

import com.easyDriving.pojo.User;
import com.easyDriving.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

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
    public @ResponseBody JSONObject register(@RequestParam String email,@RequestParam String name,@RequestParam String password,@RequestParam String password1) throws IOException {
        JSONObject jsonObject = new JSONObject();
        if (userService.emailIsEqual(email)!=0){
            jsonObject.put("email", "0");
            System.out.println(jsonObject.toString());
            return jsonObject;
        }
        if(userService.nameIsEqual(name)!=0) {
            jsonObject.put("name","1");
            System.out.println(jsonObject.toString());
            return jsonObject;
        }
        User user = new User();
        user.setU_flag("0");
        user.setU_email(email);
        user.setU_name(name);
        user.setU_password(password);
        userService.insertUser(user);
        jsonObject.put("success", "2");
        System.out.println(jsonObject.toString());
        return jsonObject;
    }
}
