package com.easyDriving.utils;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 * Created by hexing on 15-12-13.
 */
public class MailLogin extends Authenticator{
    private String name;
    private char[] pawword;

    public MailLogin(String name, char[] pawword){
        this.name = name;
        this.pawword = pawword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public char[] getPawword() {
        return pawword;
    }

    public void setPawword(char[] pawword) {
        this.pawword = pawword;
    }



    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(name,pawword);
    }
}
