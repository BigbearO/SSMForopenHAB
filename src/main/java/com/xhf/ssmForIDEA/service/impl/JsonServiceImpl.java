package com.xhf.ssmForIDEA.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xhf.ssmForIDEA.dao.RuleDao;
import com.xhf.ssmForIDEA.dao.UtilDao;
import com.xhf.ssmForIDEA.pojo.Item;
import com.xhf.ssmForIDEA.pojo.Thing;
import com.xhf.ssmForIDEA.service.JsonService;
import com.xhf.ssmForIDEA.testfunction.DomainDemo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Service
public class JsonServiceImpl implements JsonService {

    @Value("${jsonpath}")
    String jsonpath;//存储json的目录

    @Value("${rulespath}")
    String rulespath;//rules目录

    @Value("${path}")
    String paths;//config目录

    @Value("${itemspath}")
    String  itemspath;

    @Value("${sitemapspath}")
    String sitemapspath;

    @Value("${itemjson}")
    String itemjson;

    @Autowired
    RuleDao ruleDao;
    @Autowired
    UtilDao utilDao;

    @Override
    public boolean thinngstoI_S() {
        try {
            ArrayList<Thing> things =get_things();
            thingtoitem_and_sitemmap(things);

        }catch (IOException e){
            System.out.println("哦豁，json报错了");
        }
        return false;
    }

    @Override
    public boolean itemtodatabase()  {
        //先解析json
         File items=new File(itemjson);
         int max=utilDao.get_maxid_fromitem_device();

    try {
        String input = FileUtils.readFileToString(items, "UTF-8");
        JSONObject jsonObjectParent = JSONObject.parseObject(input);
        Set<String> keySetParent = jsonObjectParent.keySet();
        int num=keySetParent.size() -max;

        for(String keyParent : keySetParent){
            num--;
            String itemname=keyParent;
            String device =itemname.split("_")[0];
            JSONObject item = jsonObjectParent.getJSONObject(keyParent);//child是每个item
            //String clazz = jsonObjectChild.getString("class");
            JSONObject value =item.getJSONObject("value");
            String type=value.getString("itemType");
            String label =value.getString("label");
            Item item1 = new Item();
            item1.setDevice(device);
            item1.setItemname(itemname);
            item1.setType(type);
            utilDao.additem_device(item1);
            if (num ==0){
                break;
            }
        }
    }catch (IOException ioe){
        System.out.println("itemjson未找到");
        ioe.getStackTrace();
    }

        return true;
    }


    public   ArrayList<Thing> get_things() throws IOException {
        ArrayList things =new ArrayList<Thing>();//存储所有硬件
        //将所要thing添加进去things，
        // 然后遍历things，把每个things的channels遍历一遍，在这个遍历中，创建文档到items
        final String path =jsonpath;
        //"C:\\Users\\Dell\\Desktop\\OpenHAB\\2_5\\openhab-2.5.3\\userdata\\jsondb\\org.eclipse.smarthome.core.thing.Thing.json";

        File filepath =new File(path);

        String input = FileUtils.readFileToString(filepath, "UTF-8");
        JSONObject jsonObjectParent = JSONObject.parseObject(input);
        Set<String> keySetParent = jsonObjectParent.keySet();
        for(String keyParent : keySetParent){
            //System.out.println("key=" + keyParent);
            JSONObject jsonObjectChild = jsonObjectParent.getJSONObject(keyParent);//child是每个硬件

            String clazz = jsonObjectChild.getString("class");
            //  System.out.println("class=" + clazz);
            DomainDemo domainDemo = jsonObjectChild.getObject("value", DomainDemo.class);
            Thing thing = new Thing(domainDemo.getLabel());
            //System.out.println("label=" + domainDemo.getLabel());
            JSONObject j2 =jsonObjectChild.getJSONObject("value");//value 是属性了
            JSONArray channels = j2.getJSONArray("channels");//分级parent》child>value>channels
            if(channels.size() >0) {//如果没有channel，代表没有供给人看的功能
                for (int i = 0; i < channels.size(); i++) {
                    JSONObject object = (JSONObject) channels.get(i);//每个channel
                    String ItemType = object.getString("acceptedItemType");
                    //获取channel,uid
                    JSONObject uid=object.getJSONObject("uid");
                    String channel= uid.getJSONArray("segments").toString();
                    channel= channel.replace("[","");
                    channel= channel.replace("]","");
                    channel=  channel.replace("\"","");
                    channel= channel.replace(",",":");
                    if (ItemType != null) {
                        thing.addchannel(channel, ItemType);
                    }

                    //System.out.println("itemtype:"+ItemType+"      UID》"+channel);
                }
            }
            things.add(thing);
        }

        return things;
    }


    public  void thingtoitem_and_sitemmap(ArrayList<Thing> lists){

        System.out.println(lists.size());
        //遍历list,然后按照label创建文件

        String  itempath="items\\";

        File sitemap =new File(paths+sitemapspath);
        //
        for (Thing thing: lists) {
            String s=thing.getLabel();//用这个替换label,然后创建文件
            s=s.replace(" ","_");
            s=s.replace("/","_");
            String s2=s+".items";
            File item =new File(itemspath+s2);
            try {
                if (item.exists()){
                    boolean de= item.delete();
                    // System.out.println("文件删除"+de);
                }
                //这里开始将读thing的item写进文件
                boolean t=item.createNewFile();
                //System.out.println(s+"文件创建："+t);
            }catch (IOException IOe){
                System.out.println("文件读取失败");
            }
            catch (Exception e){
                System.out.println("创建文件失败了");
            }
            writetoitem(item,thing.getChannels(),s);
            writetositemap(sitemap,itemspath+s2,s);
            System.out.println();
        }
    }




    public  boolean writetoitem(File file , HashMap map, String groupname){
        try {
            // FileInputStream in = new FileInputStream(file);
            //写入相应的文件
            FileOutputStream out = new FileOutputStream(file);
            String group ="\nGroup "+groupname+"\n";
            out.write(group.getBytes());//创建group，写入文件
            System.out.println(group);
            //迭代遍历hashmap，将channel写入文件
            Iterator iter = map.entrySet().iterator();
            int i=0;
            //获取key和value的set
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();        //把hashmap转成Iterator再迭代到entry
                String key = (String)entry.getKey();        //从entry获取key,key是channel
                String val = (String)entry.getValue();    //从entry获取value,就是item类型
                String[] labels = key.split(":");
                String id="  item_"+labels[labels.length-1]+i+"   ";
                String label =labels[labels.length-2]+labels[labels.length-1];

               int result= item_to_databse(id,groupname);
                //现在要加group
                String s="\n"+val +id+"\""+label+"\" （"+ groupname+") {channel= \""+key+"\" }\n\n";
                i++;
                out.write(s.getBytes());
                System.out.println(s);
            }
            i=0;
            out.flush();
            //关闭流
            out.close();
        } catch (FileNotFoundException e){
            System.out.println("找不到item文件:"+groupname);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
        return true;
    }

    public int item_to_databse(String label,String itemname){
        //writetoitem中,item的名字，事物硬件的name
       int i= ruleDao.addto_itembything(label,itemname);
       return i;
    }

    public  boolean writetositemap(File file,String  path,String groupname ){

        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            //System.out.println(lines);
            lines.set(lines.size() -1,"\n");
            // System.out.println(lines);
            Files.write(Paths.get(path), lines);
        } catch (IOException e) {
            System.out.println("未找到报警规则文件");
            e.printStackTrace();
        }

        try {
            //写入相应的文件
            FileWriter fw = new FileWriter(file, true);
            String content ="Frame label=\"请点击英文书名号进入子界面控制设备" +"\" {"
                    +"Group  " +"item="+groupname+"   label=\""+groupname+"\""
                    +"\n}\n}\n";
            System.out.println(content);
            fw.write(content);
            fw.close();
            //将创建item文件的信息，定一个group， 将这个item的channel添加到这个group，组的名字就是硬件名
            // 然后将groupitem，的名字作为添加到sitemap末尾

        } catch (FileNotFoundException e){
            System.out.println("找不到sitemap文件");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
        return true;
    }
}
