package com.xhf.ssmForIDEA.controller;

import com.xhf.ssmForIDEA.service.GetRuleService;
import com.xhf.ssmForIDEA.util.MyUtil;
import com.xhf.ssmForIDEA.pojo.ItemRule;
import com.xhf.ssmForIDEA.pojo.TimerRule;
import com.xhf.ssmForIDEA.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RuleController {

    @Autowired
    GetRuleService getRuleService;

    @Autowired
    RuleService ruleService;


    @RequestMapping("/toaddrule")
    public String toaddrule(){
        return "addrule";
    }

    @RequestMapping("/toqingjing")
    public String toqingjing(Model model){
       // List<Rule> timers =getRuleService.get_timer_rules_forqingjing();
      //  List<Rule> items =getRuleService.get_item_rules_forqingjing();//这两个应该是通过service查找的

        List<TimerRule> timers=getRuleService.get_timer_rules();
        List<ItemRule> items =getRuleService.get_item_rules();

        model.addAttribute("timers",timers);
        model.addAttribute("items",items);
        return "qingjing";
    }

    @RequestMapping("/addtotimer")
    public String addtotimer(String rulename,String cron,String hms,String timerexetype,
                           String then_device_name,String then_item_id,String then_item_status,
                             Model model){//String starttime ,String endtime,

        String rule =ruleService.create_rules_fortimer(then_device_name);//设置规则在文件之中的名字，亦是文件名
        String cronhms = MyUtil.all(hms,timerexetype);
        // 上面空指针
        String item_name =ruleService.get_itemname(then_item_id);
        String itemevent =item_name +".sendCommand("+then_item_status+")\n";//
        //filecontent需要第一排加var useful，then里需要加if(useful ==1)两排}}
        String file_content =ruleService.creat_filecontentfortimer(rule,cronhms,itemevent );//start_end,

        TimerRule timerRule= new TimerRule(rule,rulename,cronhms,then_item_id,"test",
                then_item_status,file_content,"1");//starttime,endtime,
         int i = ruleService.addtotimer(timerRule);
         boolean boo =ruleService .addtofile(file_content,rule);

         if(i>0 ){
             //新增规则成功，返回到场景情景界面
             if( boo){
                 return "forward:/toqingjing";
             }else {
                 model.addAttribute("msg","新增规则数据库成功了，但内容失败了");
                 return "addrule";
             }
         }else {
             model.addAttribute("msg","不好意思，两个新增规则失败了");
             return "addrule";
         }
    }

    @RequestMapping("/addtoitem")
    public String addtoitem(String  rulename,String when_device_name,String when_item_id,String when_item_status,
                            String then_device_name,String then_item_id,String then_item_status,
                            String starttime ,String endtime,Model model ){
        String rule =ruleService.create_rules_foritem(when_device_name);
        String when =MyUtil.getWhen(when_device_name,when_item_id,when_item_status);
        String start_end =MyUtil.timeto2(starttime,endtime);//将开始与结束字符串转换为rule规则语句
        String item_name =ruleService.get_itemname(then_item_id);
        String itemevent =item_name +".sendCommand("+then_item_status+")\n";//
        //filecontent需要第一排加var useful，then里需要加if(useful ==1)两排}}
        String file_content =ruleService.creat_filecontentforitem(rule,when,start_end,itemevent );
        ItemRule itemRule =new ItemRule(rule,rulename,when_item_id,when_device_name,when_item_status,then_item_id,"test",
                then_item_status,starttime,endtime,file_content,"1");

        int i = ruleService.addtoitem(itemRule);
        boolean boo =ruleService.addtofile(file_content,rule);
        if(i>0){
            //新增规则成功，返回到场景情景界面
            return "forward:/toqingjing";

        }else {
            model.addAttribute("msg","不好意思，新增规则失败了");
            return "addrule";
        }

    }

    @RequestMapping("/toupdateitemrules")
    public String  updateitemrules(String  id,String  rule,String rulename,Model model){

       // model.addAttribute("提示","要想转发数据，记得在model里面添加");
        model.addAttribute("id",id);
        model.addAttribute("rule",rule);
        model.addAttribute("rulename",rulename);
        return "rule/updaterule";
    }
    @RequestMapping("/toupdatetimerrules")
    public String updatetimerrules(String  id,String  rule,String rulename,Model model){
        //传给前端rule的文件名字，以及展示给用户看的名字，
        model.addAttribute("id",id);
        model.addAttribute("rule",rule);
        model.addAttribute("rulename",rulename);
        return "rule/updaterule";
    }

    @RequestMapping("/updateitemrules")
    public String  update_itemrules(String  rulename,String id,String rule,
                                    String when_device_name,String when_item_id,String when_item_status,
                                    String then_device_name,String then_item_id,String then_item_status,
                                    String starttime ,String endtime,Model model ){
       // String rule =ruleService.create_rules_foritem(when_device_name);
        String when =MyUtil.getWhen(when_device_name,when_item_id,when_item_status);
        String start_end =MyUtil.timeto2(starttime,endtime);//将开始与结束字符串转换为rule规则语句
        String item_name =ruleService.get_itemname(then_item_id);
        String itemevent =item_name +".sendCommand("+then_item_status+")\n";//
        //filecontent需要第一排加var useful，then里需要加if(useful ==1)两排}}
        String file_content =ruleService.creat_filecontentforitem(rule,when,start_end,itemevent);
        ItemRule itemRule =new ItemRule(rule,rulename,when_item_id,when_device_name,when_item_status,then_item_id,"test",
                then_item_status,starttime,endtime,file_content,"1");
        itemRule.setId(Integer.parseInt(id));

        int i = getRuleService.update_itemrules(itemRule);//ruleService.addtoitem(itemRule);//
        boolean boo =getRuleService.update_rules_file(file_content,rule);
        //ruleService.addtofile(file_content,rule);
        if(i>0 && boo){
            //新增规则成功，返回到场景情景界面
            return "forward:/toqingjing";

        }else {
            model.addAttribute("msg","不好意思，更新规则失败了");
            model.addAttribute("id",id);
            model.addAttribute("rule",rule);
            model.addAttribute("rulename",rulename);
            return "rule/updaterule";
        }
        //return "rule/updaterule";
    }
    @RequestMapping("/updatetimerrules")
    public String update_timerrules(String rulename,String id,String rule,String cron,String hms,String timerexetype,
                                    String then_device_name,String then_item_id,String then_item_status,
                                    Model model){
        //传给前端rule的文件名字，以及展示给用户看的名字，
        String cronhms = MyUtil.all(hms,timerexetype);
        // 上面空指针
        String item_name =ruleService.get_itemname(then_item_id);
        String itemevent =item_name +".sendCommand("+then_item_status+")\n";//
        //filecontent需要第一排加var useful，then里需要加if(useful ==1)两排}}
        String file_content =ruleService.creat_filecontentfortimer(rule,cronhms,itemevent );//start_end,

        TimerRule timerRule= new TimerRule(rule,rulename,cronhms,then_item_id,"test",
                then_item_status,file_content,"1");//starttime,endtime,
        timerRule.setId(Integer.parseInt(id));
        int i =getRuleService.update_timerrules(timerRule);// ruleService.addtotimer(timerRule);
        boolean boo =getRuleService.update_rules_file(file_content,rule);//ruleService .addtofile();
        if(i>0 && boo){
            //新增规则成功，返回到场景情景界面
            return "forward:/toqingjing";

        }else {
            model.addAttribute("msg","不好意思，新增规则失败了");
            model.addAttribute("id",id);
            model.addAttribute("rule",rule);
            model.addAttribute("rulename",rulename);
            return "rule/updaterule";
        }

    }


    @RequestMapping("/banitemrules")
    public String banitemrules(String  id,String  rule,String useful,Model model){
            boolean bo=getRuleService.banitemrules(id, rule, useful);
            if(bo) {
                return "forward:/toqingjing";
            }else {
                model.addAttribute("msg","操作失败了");
                return toqingjing(model);
            }
    }
    @RequestMapping("/bantimerrules")
    public String bantimerrules(String  id,String  rule,String useful,Model model){
        boolean boo =getRuleService.bantimerrules(id, rule, useful);
        if(boo) {
            return "forward:/toqingjing";
        }else {
            model.addAttribute("msg","操作失败了");
            return toqingjing(model);
        }
    }

    @RequestMapping("/deleteitemrules")
    public String deleteitemrules(String  id,String  rule,Model model){
        boolean bo=getRuleService.deleteitemrules(id, rule);
        if(bo) {
            return "forward:/toqingjing";
        }else {
            model.addAttribute("msg","操作失败了");
            return toqingjing(model);
        }
    }
    @RequestMapping("/deletetimerrules")
    public String deletetimerrules(String  id,String  rule,Model model){
        boolean boo =getRuleService.deletetimerrules(id,rule);
        if(boo) {
            return "forward:/toqingjing";
        }else {
            model.addAttribute("msg","操作失败了");
            return toqingjing(model);
        }
    }


}
