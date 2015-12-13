package com.easyDriving.utils;

import javax.mail.Session;
import java.util.Properties;

/**
 * Created by hexing on 15-12-13.
 */
public class MailSend {
    private final transient Properties pros = System.getProperties();
    private transient MailLogin mailLogin;
    private transient Session session;

    public MailSend(final String smtpHostName){
        
    }
}
