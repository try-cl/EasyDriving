package com.easyDriving.pojo;

/**
 * Created by hexing on 15-12-15.
 */
public class Grade {
    private int g_id;//自增
    private int t_id;
    private int p_id;
    private int g_passrate;
    private int g_trainer;
    private int g_environment;

    public int getG_id() {
        return g_id;
    }

    public void setG_id(int g_id) {
        this.g_id = g_id;
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

    public int getG_passrate() {
        return g_passrate;
    }

    public void setG_passrate(int g_passrate) {
        this.g_passrate = g_passrate;
    }

    public int getG_trainer() {
        return g_trainer;
    }

    public void setG_trainer(int g_trainer) {
        this.g_trainer = g_trainer;
    }

    public int getG_environment() {
        return g_environment;
    }

    public void setG_environment(int g_environment) {
        this.g_environment = g_environment;
    }
}
