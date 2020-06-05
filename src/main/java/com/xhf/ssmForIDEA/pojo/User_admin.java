package com.xhf.ssmForIDEA.pojo;

public class User_admin {

    private  int id;
    private String name;
    private  int useable;//1为可用，0为封禁

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUseable() {
        return useable;
    }

    public void setUseable(int useable) {
        this.useable = useable;
    }
}
