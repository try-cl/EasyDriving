package com.easyDriving.utils;


import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * Created by hexing on 15-12-14.
 */
public class SimpleMailSend {
    public static void main(String[] args) {
        SimpleEmail email = new SimpleEmail();
        email.setHostName("smtp.qq.com");
        email.setSmtpPort(465);
        email.setSSLOnConnect(true);
        try {
            email.setAuthentication("1776898728@qq.com", "suhkxgoyunftcgaf");//邮件服务器验证：用户名/密码
            email.setCharset("UTF-8");// 必须放在前面，否则乱码
            email.addTo("936302529@qq.com");
            email.setFrom("1776898728@qq.com", "1776898728");
            email.setSubject("subject中文");
            email.setMsg("帅哥");
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }

    }

}
