package com.xhf.ssmForIDEA.service;

import com.xhf.ssmForIDEA.pojo.ItemRule;
import com.xhf.ssmForIDEA.pojo.TimerRule;

public interface RuleService {

    int addtoitem(ItemRule itemRule);
    int addtotimer(TimerRule timerRule);
    boolean addtofile(String file_content,String rule);

    String creat_filecontentfortimer(String rule,String when,String then_item);//
    String creat_filecontentforitem(String rule,String when,String then_time,String then_item);
    String create_rules_foritem(String device_name);
    String create_rules_fortimer(String device_name);//这几个是新增规则但方法

    //接下来是
    String  get_itemname(String id);



}
