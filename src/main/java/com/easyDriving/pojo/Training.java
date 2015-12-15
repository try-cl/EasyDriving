package com.easyDriving.pojo;

/**
 * Created by hexing on 15-12-15.
 */
public class Training {
    private int t_id;//自增
    private int t_trainernum;
    private int t_traineenum;
    private int t_price;
    private String t_name;
    private String t_address;
    private String t_introduction;
    private String t_phonenum;

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public int getT_trainernum() {
        return t_trainernum;
    }

    public void setT_trainernum(int t_trainernum) {
        this.t_trainernum = t_trainernum;
    }

    public int getT_traineenum() {
        return t_traineenum;
    }

    public void setT_traineenum(int t_traineenum) {
        this.t_traineenum = t_traineenum;
    }

    public int getT_price() {
        return t_price;
    }

    public void setT_price(int t_price) {
        this.t_price = t_price;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_address() {
        return t_address;
    }

    public void setT_address(String t_address) {
        this.t_address = t_address;
    }

    public String getT_introduction() {
        return t_introduction;
    }

    public void setT_introduction(String t_introduction) {
        this.t_introduction = t_introduction;
    }

    public String getT_phonenum() {
        return t_phonenum;
    }

    public void setT_phonenum(String t_phonenum) {
        this.t_phonenum = t_phonenum;
    }

}
