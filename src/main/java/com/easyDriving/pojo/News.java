package com.easyDriving.pojo;

import java.util.Date;

/**
 * Created by hexing on 15-12-15.
 */
public class News {
    private int n_id;//自增
    private String n_flag;//'0'为资讯,'1'为驾校
    private int t_id;
    private String n_title;
    private String n_content;
    private Date n_time;

    public int getN_id() {
        return n_id;
    }

    public void setN_id(int n_id) {
        this.n_id = n_id;
    }

    public String getN_flag() {
        return n_flag;
    }

    public void setN_flag(String n_flag) {
        this.n_flag = n_flag;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getN_title() {
        return n_title;
    }

    public void setN_title(String n_title) {
        this.n_title = n_title;
    }

    public String getN_content() {
        return n_content;
    }

    public void setN_content(String n_content) {
        this.n_content = n_content;
    }

    public Date getN_time() {
        return n_time;
    }

    public void setN_time(Date n_time) {
        this.n_time = n_time;
    }

}
