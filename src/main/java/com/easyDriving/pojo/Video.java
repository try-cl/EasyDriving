package com.easyDriving.pojo;

/**
 * Created by hexing on 15-12-15.
 */
public class Video {
    private int v_id;//自增
    private String v_type;
    private String v_name;//名字/路径

    public int getV_id() {
        return v_id;
    }

    public void setV_id(int v_id) {
        this.v_id = v_id;
    }

    public String getV_type() {
        return v_type;
    }

    public void setV_type(String v_type) {
        this.v_type = v_type;
    }

    public String getV_name() {
        return v_name;
    }

    public void setV_name(String v_name) {
        this.v_name = v_name;
    }
}
