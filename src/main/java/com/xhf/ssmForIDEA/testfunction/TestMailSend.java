package com.xhf.ssmForIDEA.testfunction;

import com.sun.mail.util.MailSSLSocketFactory;
import com.xhf.ssmForIDEA.controller.JsonController;
import com.xhf.ssmForIDEA.service.impl.JsonServiceImpl;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Properties;

public class TestMailSend {

    private static String from = "xhf163163@163.com"; // 发件人邮箱地址
    private static String user = "xhf163163@163.com"; // 发件人称号，同邮箱地址
    private static String password = "FRIWNLJERSQRUOLH"; // 发件人邮箱客户端授权码

    public static void main(String[] args) {
        testrandom();
    }
    public static void testrandom(){
//        JsonController jc =new JsonController();
        JsonServiceImpl js =new JsonServiceImpl();
       js.itemtodatabase();
    }

}
