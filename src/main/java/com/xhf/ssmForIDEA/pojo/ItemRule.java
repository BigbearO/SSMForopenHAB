package com.xhf.ssmForIDEA.pojo;

public class ItemRule {

    int id;
    String rule;
    String rulename;
    String when_item_id;
    String when_device_name;
    String when_item_status;
    String then_item_id;
    String then_device_name;
    String then_item_status;
    String start_time;
    String end_time;
    String file_content;
    String useful;


    public ItemRule (){

    }
    public ItemRule (int id,String rule,String rulename,String useful){
        this.id =id;
        this.rule =rule;
        this.rulename =rulename;
        this.useful =useful;
    }

    public ItemRule (String rule,String rulename,
                     String when_item_id,String when_device_name, String when_item_status,
                     String then_item_id, String then_device_name, String then_item_status,
                     String start_time, String end_time,String file_content,String useful){

        this.id =id;
        this.rule =rule;
        this.rulename =rulename;
        this.when_item_id= when_item_id;
        this.when_device_name =when_device_name;
        this.when_item_status=when_item_status;
        this.then_item_id =then_item_id;
        this.then_device_name =then_device_name;
        this.then_item_status =then_item_status;
        this.start_time =start_time;
        this.end_time =end_time;
        this.file_content =file_content;
        this.useful =useful;

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRule() {
        return rule;
    }
    public void setRule(String rule) {
        this.rule = rule;
    }
    public String getRulename() {
        return rulename;
    }
    public void setRulename(String rulename) {
        this.rulename = rulename;
    }
    public String getWhen_item_id() {
        return when_item_id;
    }
    public void setWhen_item_id(String when_item_id) {
        this.when_item_id = when_item_id;
    }
    public String getWhen_device_name() {
        return when_device_name;
    }
    public void setWhen_device_name(String when_device_name) {
        this.when_device_name = when_device_name;
    }
    public String getWhen_item_status() {
        return when_item_status;
    }
    public void setWhen_item_status(String when_item_status) {
        this.when_item_status = when_item_status;
    }
    public String getThen_item_id() {
        return then_item_id;
    }
    public void setThen_item_id(String then_item_id) {
        this.then_item_id = then_item_id;
    }
    public String getThen_device_name() {
        return then_device_name;
    }
    public void setThen_device_name(String then_device_name) {
        this.then_device_name = then_device_name;
    }
    public String getThen_item_status() {
        return then_item_status;
    }
    public void setThen_item_status(String then_item_status) {
        this.then_item_status = then_item_status;
    }
    public String getStart_time() {
        return start_time;
    }
    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }
    public String getEnd_time() {
        return end_time;
    }
    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
    public String getFile_content() {
        return file_content;
    }
    public void setFile_content(String file_content) {
        this.file_content = file_content;
    }
    public String getUseful() {
        return useful;
    }
    public void setUseful(String useful) {
        this.useful = useful;
    }


}
