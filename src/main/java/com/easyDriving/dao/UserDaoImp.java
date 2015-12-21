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

    //是否存在该邮箱
    @Override
    public int exitEmail(String u_email) throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.exitEmail(u_email);
        }finally {
            sqlSession.close();
        }
    }

    //忘记密码,添加验证邮箱的激活码
    @Override
    public void setFacticode(String u_email, String u_facticode) throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.setFacticode(u_email,u_facticode);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    //忘记密码,用过验证邮箱重设密码
    @Override
    public String getFacticode(String u_email) throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.getFacticode(u_email);
        }finally {
            sqlSession.close();
        }
    }

    //验证邮箱成功,修改标志位
    @Override
    public void modifyState() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.modifyState();
        }finally {
            sqlSession.close();
        }
    }

    //密码忘记,验证邮箱成功,修改标志位
    @Override
    public void modifyForget() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.modifyForget();
        }finally {
            sqlSession.close();
        }
    }

    //修改密码
    @Override
    public void setPassword(String u_email, String u_password) throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.setPassword(u_email,u_password);
        }finally {
            sqlSession.close();
        }
    }
}
