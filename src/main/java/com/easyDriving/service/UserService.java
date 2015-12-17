package com.easyDriving.service;

import com.easyDriving.pojo.User;

import java.io.IOException;

/**
 * Created by hexing on 15-12-15.
 */
public interface UserService {
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

}
