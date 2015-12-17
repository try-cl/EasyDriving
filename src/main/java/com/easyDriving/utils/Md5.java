package com.easyDriving.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by hexing on 15-12-17.
 */
public class Md5 {
    private static Md5 md5;
    private Md5(){}
    public static String getMd5(String str) {
        if (md5==null){
            md5 = new Md5();
        }
        MessageDigest md5 = null;
        String newstr = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            try {
                newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
                System.out.println(newstr+" "+newstr.length());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return newstr;
    }
}
