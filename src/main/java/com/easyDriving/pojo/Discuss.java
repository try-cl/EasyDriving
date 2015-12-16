package com.easyDriving.pojo;

import java.sql.Date;

/**
 * Created by hexing on 15-12-15.
 */
public class Discuss {
    private int d_id;//自增
    private int u_id;
    private int d_clicknum;//点赞数
    private String d_content;
    private Date d_time;


    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getD_clicknum() {
        return d_clicknum;
    }

    public void setD_clicknum(int d_clicknum) {
        this.d_clicknum = d_clicknum;
    }

    public String getD_content() {
        return d_content;
    }

    public void setD_content(String d_content) {
        this.d_content = d_content;
    }

    public Date getD_time() {
        return d_time;
    }

    public void setD_time(Date d_time) {
        this.d_time = d_time;
    }
}
