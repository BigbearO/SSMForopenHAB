package com.xhf.ssmForIDEA.util;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MyUtil {

    public static String timeto(String start,String  end){//将start与end转换为字符串

        StringBuffer sbu =new StringBuffer();
        sbu.append("     val Date date=new Date();//(time)\n" +
                "    var String ma=\"HH:mm:ss\"\n" +
                "    val  SimpleDateFormat forma = new SimpleDateFormat(ma)\n" +
                "    var   String nwdate = forma.format(date) \n"+
                "    val String start = \""+start+"\"\n" +
                "    val  String  end =  \""+end +"\"\n\n");
        sbu.append("      if(nwdate.compareTo(start) >0 && nwdate.compareTo(end) <0) {\n");
        return sbu.toString();
    }
    public static String timeto2(String start,String  end){//将start与end转换为字符串

        StringBuffer sbu =new StringBuffer();
        String[] starts =start.split(":");//显示这里空指针
        String[] ends =end.split(":");
        int[] st = Arrays.stream(starts).mapToInt(Integer::parseInt).toArray();
        int[] en =Arrays.stream(ends).mapToInt(Integer::parseInt).toArray();
        sbu.append("    if(now.getHourOfDay() >=" +st[0]+" && now.getMinuteOfHour >= "+st[1] +"){\n");
        sbu.append("        if(now.getHourOfDay() <=" +en[0]+" && now.getMinuteOfHour <= "+en[1] +"){\n");
        sbu.append("\n");
        return sbu.toString();
    }

    public static String getWhen(String when_device_name,String when_item_id,String when_item_status){
        StringBuffer sbuff =new StringBuffer();



        return sbuff.toString();
    }

    public static  String all(String hms,String timerexetype){//将hh:mm:ss型的字符串，按照执行类型拼接成
        String[] time =hms.split(":");
        for(int i=0;i<time.length;i++) {
            if(time[i].startsWith("0")) {
                time[i]=time[i].substring(1);
            }
        }
        String cronhms =fanzhuan(time);
        switch (timerexetype){
            case "1"://每天
                cronhms ="Time cron \""+cronhms +" * * ? \"";
                break;
            case "2"://一次
                String day =MyUtil.cron_once(hms);
                cronhms ="Time cron \""+cronhms +day;
                break;
            case "3"://周一到周五
                cronhms ="Time cron \""+cronhms +" ? * 2-6";
                break;
        }
        return cronhms;
    }

    public static String fanzhuan(String [] strs){//翻转字符串，组成一个string返回
        StringBuffer sbuff=new StringBuffer();
        for (int i=strs.length-1;i>=0;i--){
            sbuff.append(strs[i] +" ");
        }

        return sbuff.toString();
    }

    public static String cron_once(String time) {
        Date date=new Date();//(time);
        String ma="yyyyMMdd HH:mm:ss";
        SimpleDateFormat forma=new SimpleDateFormat(ma);
        String nwdate=forma.format(date);
        String [] news =nwdate.split(" ");
        int res =news[1].compareTo(time);
        int x=Integer.parseInt(news[0]);
        int day =x%100;
        int month =(x/100)%100;
        int year =x/10000;
        if(res>0){
            switch (month){
                case 1:if (day+1 > 31){
                    month =month+1;
                    day =1;
                }
                case 2:if (day+1 >28){
                    month =month+1;
                    day =1;
                }
                case 3:if (day+1 > 31){
                    month =month+1;
                    day =1;
                }
                case 4:if (day+1 > 30){
                    month =month+1;
                    day =1;
                }
                case 5:if (day+1 > 31){
                    month =month+1;
                    day =1;
                }
                case 6:if (day+1 > 30){
                    month =month+1;
                    day =1;
                }
                case 7:if (day+1 > 31){
                    month =month+1;
                    day =1;
                }
                case 8:if (day+1 > 31){
                    month =month+1;
                    day =1;
                }
                case 9:if (day+1 > 30){
                    month =month+1;
                    day =1;
                }
                case 10:if (day+1 > 31){
                    month =month+1;
                    day =1;
                }
                case 11:if (day+1 > 30){
                    month =month+1;
                    day =1;
                }
                case 12:if (day+1 > 31){
                    year =year+1;
                    month=1;
                    day =1;
                }
            }
        }
        return " "+day+" "+month+" ? "+year;
    }

}
