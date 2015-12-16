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
    public int nameIsEqual(String name) throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.nameIsEqual(name);
        }finally {
            sqlSession.close();
        }
    }
    //验证注册时是否邮箱已经注册
    @Override
    public int emailIsEqual(String email) throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.emailIsEqual(email);
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


}
