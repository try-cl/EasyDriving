package com.easyDriving.pojo;

/**
 * Created by hexing on 15-12-15.
 */
public class Image {
    private int i_flag;//0 驾校 1 陪练  2 资讯  3 朋友圈说说 4 题
    private int t_id;
    private int p_id;
    private int n_id;
    private int d_id;
    private int s_id;
    private String i_name;

    private int i_id;//自增

    public int getI_id() {
        return i_id;
    }

    public void setI_id(int i_id) {
        this.i_id = i_id;
    }

    public int getI_flag() {
        return i_flag;
    }

    public void setI_flag(int i_flag) {
        this.i_flag = i_flag;
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

    public int getN_id() {
        return n_id;
    }

    public void setN_id(int n_id) {
        this.n_id = n_id;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getI_name() {
        return i_name;
    }

    public void setI_name(String i_name) {
        this.i_name = i_name;
    }

}
