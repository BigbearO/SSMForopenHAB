package com.xhf.ssmForIDEA.controller;

import com.xhf.ssmForIDEA.pojo.Miyue;
import com.xhf.ssmForIDEA.service.MiyueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MiyueController {
    @Autowired
    MiyueService miyueService;

    @RequestMapping("/tomiyue")
    public String tomiyue(Model model){
        List<Miyue> list =miyueService.get_miyues();
        model.addAttribute("miyues",list);
        return "miyue/miyue";
    }

    @RequestMapping("/toadd")
    public String toadd(){
        return "miyue/miyue_add";
    }

    @RequestMapping("/toupdate")
    public String toupdate(String id,String miyue,Model model){
        model.addAttribute("id",id);
        model.addAttribute("miyue",miyue);
        return "miyue/miyue_update";
    }

    /* 以上四个是到对应界面的控制器*/

    @RequestMapping("/addmiyue")
    public String addmiyue(String miyue,Model model){
       int result =miyueService.addmiyue(miyue);
       if(result >0){
           return "forward:/tomiyue";
       }else {
           model.addAttribute("msg","抱歉，新增密钥失败了");
           model.addAttribute(  " miyue",miyue);
           return "miyue/miyue_add";
       }

    }

    @RequestMapping("/updatemiyue")
    public String updatemiyue(String id, String miyue,Model model){
        int idnew =Integer.parseInt(id);
        int re =miyueService.updatemiyue(idnew, miyue);
        if(re>0){
            return "forward:/tomiyue";
        }else {
            model.addAttribute("msg","抱歉，更新密钥失败了");
            model.addAttribute(  " miyue",miyue);
            model.addAttribute("id",id);
            //测试
            return "miyue/miyue_update";
        }
    }

    @RequestMapping("/deletemiyue")
    public String deletemiyue(String id,String miyue,Model model){

        int idnew =Integer.parseInt(id);
        int res = miyueService.deletemiyue(idnew);
        if(res>0){

        }else {
            model.addAttribute("msg","抱歉，删除密钥失败了");
        }
        return "forward:/tomiyue";
    }


}
