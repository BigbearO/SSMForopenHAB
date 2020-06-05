package com.xhf.ssmForIDEA.service.impl;

import com.xhf.ssmForIDEA.dao.UserDao;
import com.xhf.ssmForIDEA.pojo.User;
import com.xhf.ssmForIDEA.service.AlertSevice;
import com.xhf.ssmForIDEA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    AlertSevice alertSevice;

    @Override
    public int login(String name, String pass) {//返回-1，表示用户不存在，返回0普通用户，返回1超级管理员，-2则是封禁用户
        User user =userDao.FindUserByNamePass(name,pass);
        if(user !=null){
            if (user.getUseable() > 0) {
                alertSevice.changemailAdress(user.getMail());
                return  user.getUsertype();
            }else {
                return -2;
            }
        }
        return -1;//用户不存在
    }

    @Override
    public int insert(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public int findUserByName(String name) {
        return  userDao.findUserByName(name);
    }

    @Override
    public int findmiyue(String miyue) {
        return userDao.findmiyue(miyue);
    }

    @Override
    public boolean send163mail(String to, String text, String title) {
        String from = "xhf163163@163.com"; // 发件人邮箱地址
        String user = "xhf163163@163.com"; // 发件人称号，同邮箱地址
        String password = "FRIWNLJERSQRUOLH"; // 发件人邮箱客户端授权码

        Properties props = new Properties();
       // Properties mailsendconfig = PropertiesLoaderUtils.loadAllProperties("mailsendconfig.properties");
        props.setProperty("mail.smtp.host", "smtp.163.com"); // 设置发送邮件的邮件服务器的属性（这里使用网易的smtp服务器）
        props.put("mail.smtp.host", "smtp.163.com"); // 需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有这一条）
        props.put("mail.smtp.auth", "true"); // 用刚刚设置好的props对象构建一个session
        Session session = Session.getDefaultInstance(props); // 有了这句便可以在发送邮件的过程中在console处显示过程信息，供调试使
        // 用（你可以在控制台（console)上看到发送邮件的过程）
        //session.setDebug(true); // 用session为参数定义消息对象
        MimeMessage message = new MimeMessage(session); // 加载发件人地址
        try {
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); // 加载收件人地址
            message.setSubject(title); // 加载标题
            Multipart multipart = new MimeMultipart(); // 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
            BodyPart contentPart = new MimeBodyPart(); // 设置邮件的文本内容
            contentPart.setContent(text, "text/html;charset=utf-8");
            multipart.addBodyPart(contentPart);
            message.setContent(multipart);
            message.saveChanges(); // 保存变化
            Transport transport = session.getTransport("smtp"); // 连接服务器的邮箱
            transport.connect("smtp.163.com", user, password); // 把邮件发送出去
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean testyanzhengma( String yanzhengma,String s) {
        return s.equals(yanzhengma);
    }

    @Override
    public String scyzm() {//生成验证码
        String v = String.valueOf(new Random().nextInt(899999) + 100000);
        return v;
    }

    @Override
    public int test_mailadress(String mailadress) {
        return userDao.test_mailadress(mailadress);
    }
}
