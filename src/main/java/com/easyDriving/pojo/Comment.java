package com.easyDriving.pojo;

import java.util.Date;

/**
 * Created by hexing on 15-12-15.
 */
public class Comment {
    private int c_id;//自增
    private String c_flag;//0 驾校  1 陪练  2 朋友圈说说
    private int c_fromid;//用户
    private int t_id;
    private int p_id;
    private int d_id;
    private String c_content;
    private Date c_time;

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_flag() {
        return c_flag;
    }

    public void setC_flag(String c_flag) {
        this.c_flag = c_flag;
    }

    public int getC_fromid() {
        return c_fromid;
    }

    public void setC_fromid(int c_fromid) {
        this.c_fromid = c_fromid;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public String getC_content() {
        return c_content;
    }

    public void setC_content(String c_content) {
        this.c_content = c_content;
    }

    public Date getC_time() {
        return c_time;
    }

    public void setC_time(Date c_time) {
        this.c_time = c_time;
    }
}
