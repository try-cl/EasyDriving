package com.easyDriving.dao;

import com.easyDriving.pojo.User;

import java.io.IOException;

/**
 * Created by hexing on 15-12-15.
 */
public interface UserDao {
    //验证注册时是否已有重名用户
    public int nameIsEqual(String u_name) throws IOException;
    //验证注册时是否邮箱已经注册
    public int emailIsEqual(String u_email) throws IOException;
    //注册,插入用户信息
    public void insertUser(User user) throws IOException;
    //验证邮箱,获取验证码
    public String getActicode(String u_name) throws IOException;
    //验证登录
    public int doLogin(String u_email,String u_password) throws IOException;
    //是否存在该邮箱
    public int exitEmail(String u_email) throws IOException;

    //忘记密码,添加验证邮箱的激活码
    public void setFacticode(String u_email,String u_facticode) throws IOException;

    //忘记密码,用过验证邮箱重设密码
    public String getFacticode(String u_email) throws IOException;

    //验证邮箱成功,修改标志位
    public void modifyState() throws IOException;

    //密码忘记,验证邮箱成功,修改标志位
    public void modifyForget() throws IOException;

    //修改密码
    public void setPassword(String u_email,String u_password) throws IOException;
}
