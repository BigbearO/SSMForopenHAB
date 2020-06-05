package com.xhf.ssmForIDEA.controller;

import com.xhf.ssmForIDEA.pojo.User_admin;
import com.xhf.ssmForIDEA.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/touser_admin")
    public String to(Model model){
        List<User_admin> users =adminService.getusers();
        model.addAttribute("users",users);
        return "admin/user_manager";
    }

    @RequestMapping("/banuser")
    public String changeUser_useable(String id,String useable,Model model){//封禁用户可用性，(String id,String name)

        int userid =Integer.parseInt(id);
        //0是封禁用户，1位可用用户
        int result =adminService.changeUser_useable(userid,useable);
        if(result > 0){//操作成功则，返回list界面

        }else {
            model.addAttribute("msg","不好意思，操作失败");
            //这里试一下，能不能保留原本的数据，不能就需要换成转发，答案：不能
        }
        return to(model);
    }
}


