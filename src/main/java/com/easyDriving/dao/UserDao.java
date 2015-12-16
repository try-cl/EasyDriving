package com.easyDriving.dao;

import com.easyDriving.pojo.User;

import java.io.IOException;

/**
 * Created by hexing on 15-12-15.
 */
public interface UserDao {
    //验证注册时是否已有重名用户
    public int nameIsEqual(String name) throws IOException;
    //验证注册时是否邮箱已经注册
    public int emailIsEqual(String email) throws IOException;
    //注册,插入用户信息
    public void insertUser(User user) throws IOException;

}
