package com.xhf.ssmForIDEA.pojo;

public class TimerRule {

    int id;
    String rule;
    String rulename;
    String when_cron;
    String then_item_id;
    String then_device_name;
    String then_item_status;
    String file_content;
    String useful;

    public TimerRule (){

    }
    public TimerRule (int id,String rule,String rulename,String useful){
        this.id =id;
        this.rule =rule;
        this.rulename =rulename;
        this.useful =useful;
    }

    public TimerRule (String rule,String rulename,String when_cron,String then_item_id,
                      String then_device_name, String then_item_status,
                      String file_content,String useful){//String start_time,String end_time,
      //  this.id =id;
        this.rule =rule;
        this.rulename =rulename;
        this.when_cron=when_cron;
        this.then_item_id =then_item_id;
        this.then_device_name =then_device_name;
        this.then_item_status =then_item_status;
     //   this.start_time =start_time;this.end_time =end_time;
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
    public String getWhen_cron() {
        return when_cron;
    }
    public void setWhen_cron(String when_cron) {
        this.when_cron = when_cron;
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
//    public String getStart_time() {
//        return start_time;
//    }
//    public void setStart_time(String start_time) {
//        this.start_time = start_time;
//    }
//    public String getEnd_time() {
//        return end_time;
//    }
//    public void setEnd_time(String end_time) {
//        this.end_time = end_time;
//    }
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
