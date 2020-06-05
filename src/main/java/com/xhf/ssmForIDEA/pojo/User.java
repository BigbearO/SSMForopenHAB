package com.xhf.ssmForIDEA.pojo;

public class User {

    private String name;
    private String pass;
    private String mail;
    private int    usertype;//0为普通，1为超级
    private  int useable;//1为可用，0为封禁
    //无参构造器
    public User() {
    }

    public User(String name, String pass) {
        super();
        this.name = name;
        this.pass = pass;
    }

    public User(String name, String pass,String mail,int usertype,int userale) {
        super();
        this.name = name;
        this.pass = pass;
        this.mail =mail;
        this.useable =userale;
        this.usertype =usertype;

    }

    public String getName() {
        return name;
    }
    public String getPass(){
        return  pass;
    }
    public String getMail(){
        return  mail;
    }
    public int getUsertype(){
        return  usertype;
    }
    public int getUseable(){
        return useable;
    }

    public void setMail(String mail){
        this.mail =mail;
    }
    public void setName(String name){
        this.name =name;
    }
    public void setPass(String pass){
        this.pass =pass;
    }
    public void setUsertype(int usertype){this.usertype =usertype;}
    public void setUseable(int useable){
        this.useable =useable;
    }
}
