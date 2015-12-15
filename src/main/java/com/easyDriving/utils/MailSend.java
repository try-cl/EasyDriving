package com.easyDriving.utils;


import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * Created by hexing on 15-12-14.
 */
public class MailSend {
    private static MailSend mailSend;
    private MailSend(){}
    public static void SendMail(String to){
        if(mailSend == null){
            mailSend = new MailSend();
        }
        HtmlEmail email = new HtmlEmail();
        email.setHostName("smtp.qq.com");
        email.setSmtpPort(465);
        email.setAuthentication("1776898728@qq.com", "mraaxppugeeyhheb");//邮件服务器验证：用户名/密码
        email.setSSLOnConnect(true);
        email.setCharset("UTF-8");// 必须放在前面，否则乱码
        try {
            email.setFrom("1776898728@qq.com", "1776898728");
            email.setSubject("subject中文");
            email.setMsg("https://www.baidu.com/");
            email.setHtmlMsg("起床啦,别忘拿实验报告!!!");
            email.addTo(to);
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

}
