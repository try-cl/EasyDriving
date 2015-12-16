package com.easyDriving.mapper;

import com.easyDriving.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * Created by hexing on 15-12-15.
 */
public interface UserMapper {
    //验证注册时是否已有重名用户
    @Select("select count(u_id) from user where u_name = #{name}")
    public int nameIsEqual(String name);

    //验证注册时是否邮箱已经注册
    @Select("select count(u_id) from user where u_email = #{email}")
    public int emailIsEqual(String email);

    //注册,插入用户信息
    @Insert("insert into user (u_flag,u_name,u_email,u_password) values(#{u_flag},#{u_name},#{u_email},#{u_password})")
    public void insertUser(User user);
}
