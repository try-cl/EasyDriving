package com.easyDriving.pojo;

/**
 * Created by hexing on 15-12-15.
 */
public class User {
    private int u_id; //自增
    private String u_flag; //'0'代表管理员,'1'代表用户
    private String u_image;
    private String u_name;
    private String u_email;
    private String u_phonenum;
    private String u_sex;
    private String u_address;
    private String u_password;
    private String u_state;//用户是否激活
    private String u_acticode;//随机激活码
    private String u_forget;//用户忘记密码验证标志
    private String u_facticode;//忘记密码的随机码

    public String getU_forget() {
        return u_forget;
    }

    public void setU_forget(String u_forget) {
        this.u_forget = u_forget;
    }

    public String getU_facticode() {
        return u_facticode;
    }

    public void setU_facticode(String u_facticode) {
        this.u_facticode = u_facticode;
    }

    public String getU_state() {
        return u_state;
    }

    public void setU_state(String u_state) {
        this.u_state = u_state;
    }

    public String getU_acticode() {
        return u_acticode;
    }

    public void setU_acticode(String u_acticode) {
        this.u_acticode = u_acticode;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_flag() {
        return u_flag;
    }

    public void setU_flag(String u_flag) {
        this.u_flag = u_flag;
    }

    public String getU_image() {
        return u_image;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }
    public void setU_image(String u_image) {
        this.u_image = u_image;
    }

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    public String getU_phonenum() {
        return u_phonenum;
    }

    public void setU_phonenum(String u_phonenum) {
        this.u_phonenum = u_phonenum;
    }

    public String getU_sex() {
        return u_sex;
    }

    public void setU_sex(String u_sex) {
        this.u_sex = u_sex;
    }

    public String getU_address() {
        return u_address;
    }

    public void setU_address(String u_address) {
        this.u_address = u_address;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

}
