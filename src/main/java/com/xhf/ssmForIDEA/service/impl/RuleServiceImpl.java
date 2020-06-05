package com.xhf.ssmForIDEA.service.impl;

import com.xhf.ssmForIDEA.dao.RuleDao;
import com.xhf.ssmForIDEA.dao.UtilDao;
import com.xhf.ssmForIDEA.pojo.ItemRule;
import com.xhf.ssmForIDEA.pojo.TimerRule;
import com.xhf.ssmForIDEA.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class RuleServiceImpl implements RuleService {

    @Autowired
    RuleDao ruleDao;

    @Autowired
    UtilDao utilDao;


    @Value("${rulespath}")//@Value("#{rulespath}")
    String rulespath;


    @Override
    public int addtoitem(ItemRule itemRule) {

        //在这里更改智能需要的结果事件的属性,包括then的三大,以及处理起始结束但时间，还有filecontent
        String[] starts=itemRule.getStart_time().split(":");
        String s=itemRule.getThen_item_status();

        return ruleDao.addtoitem(itemRule);
    }

    @Override
    public int addtotimer(TimerRule timerRule) {
        return ruleDao.addtotimer(timerRule);
    }


    public boolean addtofile(String file_content,String rule)  {
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

    @Override
    public String creat_filecontentfortimer(String rule,String when, String then_item) {//String then_time,

        StringBuffer stringBuffer =new StringBuffer();
        stringBuffer.append("   var useful =1 ；\n");
        stringBuffer.append("   rule \""+rule+"\"\n");
        stringBuffer.append("   when \n     "+when+"\n" );
        stringBuffer.append("   then\n");
        stringBuffer.append("   if(useful ==1){\n");
        stringBuffer.append("   "+then_item+"\n");
        stringBuffer.append("       }\n     }\n }");
        return stringBuffer.toString();
    }

    @Override
    public String creat_filecontentforitem(String rule, String when, String then_time, String then_item) {
        StringBuffer stringBuffer =new StringBuffer();
        stringBuffer.append("   var useful =1; \n");
        stringBuffer.append("   rule \""+rule+"\"\n");
        stringBuffer.append("   when \n     "+when+"\n" );
        stringBuffer.append("   then\n");
        stringBuffer.append("  if(useful ==1){\n");
        stringBuffer.append("   "+then_time+"   \n");
        stringBuffer.append("   "+then_item+"\n");
        stringBuffer.append("       }\n     }\n }");
        return stringBuffer.toString();
    }


    @Override
    public  String create_rules_fortimer(String device_name){//根据所选设备与item
        StringBuffer sbuff=new StringBuffer();
        int i = utilDao.get_maxid_fromtimer()+1;

        sbuff.append(device_name+"_");
        sbuff.append("_"+i+"_timer");

        return sbuff.toString();
    }

    @Override
    public String get_itemname(String id) {
        return utilDao.get_itemname(Integer.parseInt(id));
    }


    @Override
    public  String create_rules_foritem(String device_name){//根据所选设备与item
        StringBuffer sbuff=new StringBuffer();
        int i = utilDao.get_maxid_fromitem()+1;
        sbuff.append(device_name+"_");
        sbuff.append("_"+i+"_item");

        return sbuff.toString();
    }


}
