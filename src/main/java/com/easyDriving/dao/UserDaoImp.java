package com.easyDriving.dao;

import com.easyDriving.mapper.UserMapper;
import com.easyDriving.pojo.User;
import com.easyDriving.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.io.IOException;

/**
 * Created by hexing on 15-12-15.
 */
@Repository
public class UserDaoImp implements UserDao{
    //验证注册时是否已有重名用户
    @Override
    public int nameIsEqual(String u_name) throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.nameIsEqual(u_name);
        }finally {
            sqlSession.close();
        }
    }
    //验证注册时是否邮箱已经注册
    @Override
    public int emailIsEqual(String u_email) throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.emailIsEqual(u_email);
        }finally {
            sqlSession.close();
        }
    }

    //注册,插入用户信息
    @Override
    public void insertUser(User user) throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.insertUser(user);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    //验证邮箱,获取验证码
    @Override
    public String getActicode(String u_name) throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.getActicode(u_name);
        }finally {
            sqlSession.close();
        }
    }

    //验证登录
    @Override
    public int doLogin(String u_email, String u_password) throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.doLogin(u_email,u_password);
        }finally {
            sqlSession.close();
        }
    }


}
