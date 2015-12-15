package com.easyDriving.pojo;

import java.util.Date;

/**
 * Created by hexing on 15-12-15.
 */
public class Reply {
    private int r_id;
    private int r_fromid;
    private int r_toid;
    private int c_id;
    private String r_content;
    private Date r_time;

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public int getR_fromid() {
        return r_fromid;
    }

    public void setR_fromid(int r_fromid) {
        this.r_fromid = r_fromid;
    }

    public int getR_toid() {
        return r_toid;
    }

    public void setR_toid(int r_toid) {
        this.r_toid = r_toid;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getR_content() {
        return r_content;
    }

    public void setR_content(String r_content) {
        this.r_content = r_content;
    }

    public Date getR_time() {
        return r_time;
    }

    public void setR_time(Date r_time) {
        this.r_time = r_time;
    }
}
