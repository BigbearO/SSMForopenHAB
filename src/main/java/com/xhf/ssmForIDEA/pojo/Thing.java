package com.xhf.ssmForIDEA.pojo;

import java.util.HashMap;

public class Thing {

    private String label;//硬件标签，一般表示名字
    private HashMap channels =new HashMap();//

    public Thing(){

    }

    public Thing(String  label){
        this.label =label;
    }


    public void addchannel(String channel,String itemType){
        channels.put(channel,itemType);
    }
    public HashMap getChannels(){
        return channels;
    }
    public void setLabel(String label){
        this.label =label;
    }

    public String getLabel(){
        return label;
    }
}
