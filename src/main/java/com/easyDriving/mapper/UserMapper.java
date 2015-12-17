package com.easyDriving.mapper;

import com.easyDriving.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * Created by hexing on 15-12-15.
 */
public interface UserMapper {
    //验证注册时是否已有重名用户
    @Select("select count(u_id) from user where u_name = #{u_name}")
    public int nameIsEqual(String u_name);

    //验证注册时是否邮箱已经注册
    @Select("select count(u_id) from user where u_email = #{u_email}")
    public int emailIsEqual(String u_email);

    //注册,插入用户信息
    @Insert("insert into user (u_flag,u_name,u_email,u_password,u_state,u_acticode) values(#{u_flag},#{u_name},#{u_email},#{u_password},#{u_state},#{u_acticode})")
    public void insertUser(User user);

    //验证邮箱,获取验证码
    @Select("select u_acticode from user where u_name=#{u_name} and u_state = '0'")
    public String getActicode(String u_name);

    //验证登录
    @Select("select count(u_id) from user where u_email=#{u_email} and u_password = #{u_password}")
    public int doLogin(String u_email,String u_password);
}
