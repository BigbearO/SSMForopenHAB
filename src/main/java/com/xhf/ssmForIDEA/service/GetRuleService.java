package com.xhf.ssmForIDEA.service;

import com.xhf.ssmForIDEA.pojo.ItemRule;
import com.xhf.ssmForIDEA.pojo.TimerRule;

import java.util.List;

public interface GetRuleService {

    boolean bantimerrules(String  id,String rule,String useful);
    boolean banitemrules(String  id,String  rule,String useful);//启用禁用规则的方法

    boolean deleteitemrules(String  id,String rule);
    boolean deletetimerrules(String  id,String rule);

    List<ItemRule> get_item_rules();
    List<TimerRule> get_timer_rules();

    int update_itemrules(ItemRule itemRule);

    int update_timerrules(TimerRule timerRule);
    boolean update_rules_file(String file_content,String rule);

}
