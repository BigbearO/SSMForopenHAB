package com.xhf.ssmForIDEA.pojo;

import java.util.HashMap;

public class Devices {



    /*此类用于将设备名与属性作为json,传递到前端*/
    //暂且不实习此功能，直接前端写死
    private String[] device_names;//或者Arraylist

    private HashMap[] device_shuxing;


    public Devices(){

    }
    public Devices(String[] device_names,HashMap[] device_shuxing){
        this.device_names =device_names;
        this.device_shuxing =device_shuxing;//记住要实例化里面的对象

    }
    public HashMap[] getDevice_shuxing() {
        return device_shuxing;
    }

    public void setDevice_shuxing(HashMap[] device_shuxing) {
        this.device_shuxing = device_shuxing;
    }

    public void setDevice_names(String[] device_names) {
        this.device_names = device_names;
    }

    public String[] getDevice_names() {
        return device_names;
    }

}
