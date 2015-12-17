package com.easyDriving.service;

import com.easyDriving.dao.UserDao;
import com.easyDriving.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by hexing on 15-12-15.
 */
@Service
public class UserServiceImp implements UserService{
    @Autowired
    UserDao userDao;

    //验证注册时是否已有重名用户
    @Override
    public int nameIsEqual(String u_name) throws IOException {
        return userDao.nameIsEqual(u_name);
    }
    //验证注册时是否邮箱已经注册
    @Override
    public int emailIsEqual(String u_email) throws IOException {
        return userDao.emailIsEqual(u_email);
    }

    //注册,插入用户信息
    @Override
    public void insertUser(User user) throws IOException {
        userDao.insertUser(user);
    }

    //验证邮箱,获取验证码
    @Override
    public String getActicode(String u_name) throws IOException {
        return userDao.getActicode(u_name);
    }

    //验证登录
    @Override
    public int doLogin(String u_email, String u_password) throws IOException {
        return userDao.doLogin(u_email,u_password);
    }
}
