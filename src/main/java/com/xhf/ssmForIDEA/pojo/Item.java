package com.xhf.ssmForIDEA.pojo;

public class Item {
    String itemname;//通过下划线,区分设备名
    String type;
    String device;

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getItemname() {
        return itemname;
    }

    public void setDevice(String label) {
        this.device = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDevice() {
        return device;
    }
}
