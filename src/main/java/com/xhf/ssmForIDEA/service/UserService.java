package com.xhf.ssmForIDEA.service;


import com.xhf.ssmForIDEA.pojo.User;
//import org.springframework.stereotype.Service;


public interface UserService {
    int login(String name, String pass);//通过用户名与密码登录

    /*以上是登录相关接口
    */
    int findUserByName(String name);//通过姓名查找用户，保证注册时用户名唯一
    int findmiyue(String miyue);//校验密钥
    String scyzm();//生成验证码字符串

    int test_mailadress(String mailadress);
    boolean send163mail(String to, String text, String title);//发送验证码
    boolean testyanzhengma( String yanzhengma,String s);
    int insert(User user);//将注册的用户插入数据库

    /*以上是注册相关接口
     */

}
