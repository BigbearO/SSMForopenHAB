package com.xhf.ssmForIDEA.service.impl;

import com.xhf.ssmForIDEA.dao.RuleDao;
import com.xhf.ssmForIDEA.pojo.ItemRule;
import com.xhf.ssmForIDEA.pojo.TimerRule;
import com.xhf.ssmForIDEA.service.GetRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class GetRuleServiceImpl implements GetRuleService {

    @Autowired
    RuleDao ruleDao;

    @Value("${rulespath}")//  @Value("#{prop['rulespath']}")
    String rulespath;

    @Override
    public boolean bantimerrules(String id, String  rule,String useful) {//更改timer规则可用性
        //根据ID查名字，然后将得到的名字封装,
        //  String name =ruleDao.select_timer_rule_byid(id);
        System.out.println("文件::"+rulespath);
        String path =rulespath +rule+".rules";
        String use =(useful.equals("1"))?"0":"1";

        boolean changed=change_rule_useful(path,use);
        System.out.println("更改文件可用性:"+changed);

        int i=ruleDao.update_timer_rule_useful(id,use);
        if(changed ==true && i>0) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean banitemrules(String id,String  rule, String useful) {//更改item规则可用性

        System.out.println("文件::"+rulespath);
        String path =rulespath +rule+".rules";
        String use =(useful.equals("1"))?"0":"1";
        boolean changed=change_rule_useful(path,use);
        System.out.println("更改文件可用性:"+changed);

        int i=ruleDao.update_item_rule_useful(id,use);

        if(changed ==true && i>0) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteitemrules(String id,String rule) {

        int re=ruleDao.deleteitemrules(Integer.parseInt(id));
        boolean bo =delete_rule(rulespath+rule+".rules");

        if(re>0 && bo){
            return true;
        }
        return false;
    }

    @Override
    public boolean deletetimerrules(String id,String rule) {
        int re=ruleDao.deletetimerrules(Integer.parseInt(id));
        boolean bo =delete_rule(rulespath+rule+".rules");
        if(re>0 && bo){
            return true;
        }
        return false;
    }

    public boolean change_rule_useful(String  path,String useful){//更改规则可用性
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            //System.out.println(lines);
            //String use =(useful.equals("1"))?"0":"1";
            lines.set(0,"var useful= "+useful+"");
            // System.out.println(lines);
            Files.write(Paths.get(path), lines);
            return true;
        } catch (IOException e) {
            System.out.println("未找到对应规则文件");
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete_rule(String  path){

        boolean de =true;
        File item =new File(path);
        if (item.exists()){
             de= item.delete();
        }
        return de;
    }

    @Override
    public List<ItemRule> get_item_rules() {//获取所有item规则属性
        return ruleDao.select_all_itemrules();
    }

    @Override
    public List<TimerRule> get_timer_rules() {//获取所有timer规则属性
        return ruleDao.select_all_timerrules();
    }

    @Override
    public int update_itemrules(ItemRule itemRule) {

        return ruleDao.update_itemrules(itemRule);
    }


    @Override
    public int update_timerrules(TimerRule timerRule) {
        return ruleDao.update_timerrules(timerRule);
    }

    @Override
    public boolean update_rules_file(String file_content,String rule) {
        File rulesfile =new File(rulespath +rule+".rules");
        try {
            FileOutputStream out = new FileOutputStream(rulesfile);
            out.write(file_content.getBytes());
            out.flush();
            //关闭流
            out.close();
        }catch (FileNotFoundException fe){
            System.out.println("文件未找到");
            return false;
        } catch (IOException e) {

            e.printStackTrace();
            return  false;
        }

        return true;
    }


}
