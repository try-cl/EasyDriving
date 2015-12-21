package com.easyDriving.mapper;

import com.easyDriving.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    //验证邮箱成功,修改标志位
    @Update("update user set u_state = '1' ")
    public void modifyState();

    //验证登录
    @Select("select count(u_id) from user where u_email=#{u_email} and u_password = #{u_password}")
    public int doLogin(String u_email,String u_password);

    //是否存在该邮箱
    @Select("select count(u_id) from user where u_email=#{u_email}")
    public int exitEmail(String u_email);

    //忘记密码,添加验证邮箱的激活码
    @Insert("insert into user (u_forget,u_facticode) values('0',#{u_facticode}) where u_email=#{u_email}")
    public void setFacticode(String u_email,String u_facticode);

    //忘记密码,用过验证邮箱重设密码
    @Select("select u_facticode from user where  u_email=#{u_email} and u_forget = '0'")
    public String getFacticode(String u_email);

    //密码忘记,验证邮箱成功,修改标志位
    @Update("update user set u_forget = '1' ")
    public void modifyForget();

    //修改密码
    @Update("update user set u_password = #{u_password} where u_email = #{u_email}")
    public void setPassword(String u_email,String u_password);
}
