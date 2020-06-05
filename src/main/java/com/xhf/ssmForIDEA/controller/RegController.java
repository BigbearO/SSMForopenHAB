package com.xhf.ssmForIDEA.controller;

import com.xhf.ssmForIDEA.pojo.User;
import com.xhf.ssmForIDEA.pojo.YanZhengMa;
import com.xhf.ssmForIDEA.service.AlertSevice;
import com.xhf.ssmForIDEA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegController {

    @Autowired
    UserService userService;//自动装配userService

    @Autowired
    AlertSevice alertSevice;

    YanZhengMa yzm =new YanZhengMa();



    @RequestMapping("/toReg")//跳转到登陆界面
    public String toReg() {
        return "user/reg1";
    }

    @RequestMapping("/Reg")//用户点击注册，后请求到这里，此方法调用userservice,注册到数据库
    public String Reg(@RequestParam String name, @RequestParam String pass, HttpServletRequest request, Model model) {
        String mail =(String) request.getSession().getAttribute("mail");
        User user =new User(name,pass,mail,0,1);
        // 到数据库比对
        int result = userService.findUserByName(name);
        if (result > 0) {
            model.addAttribute("msg", "用户名已存在");
            return "user/reg1";

        } else {
            int ret = userService.insert(user);
            if (ret > 0) {
                alertSevice.changemailAdress(user.getMail());
                request.getSession().setAttribute("user", user);
                return "main";//"forward:/tom.do";
            } else {
                model.addAttribute("msg1", "注册出错，请重试");
                return "user/reg1";
            }
        }
    }
    @RequestMapping("/SentMail")
    @ResponseBody()
    public String sendmail(@RequestParam String mailadress, HttpServletRequest request, Model model){
        int exist = userService.test_mailadress(mailadress);
        if(exist >0) {
            return "exist";
        }

        String s=userService.scyzm();
        request.getSession().setAttribute("mailadress",mailadress);
        yzm.setMailadress(mailadress);
        yzm.setYzm(s);
        //userService.send163mail(mailadress,"验证码是："+s,"openHAB注册验证码如下，若您并无此操作，请忽略");
        System.out.println("验证码是：--"+s);
        return "success";
    }



    @RequestMapping("/Testyanzhengma")
    public  String testyanzhengma(@RequestParam String mailadress,@RequestParam String yanzhengma, HttpServletRequest request, Model model){
        //在此调用service方法，将发送的验证码与输入的进行验证,验证通过就将邮箱写到session里
        boolean i=userService.testyanzhengma(yanzhengma,yzm.getYzm());// &&
        System.out.println(yanzhengma +"与"+yzm.getYzm());
        System.out.println("账号对比结果"+userService.testyanzhengma(mailadress,yzm.getMailadress()));
        System.out.println(i);
        //boolean i=true;
        if(i) {
             request.getSession().setAttribute("mailadress",mailadress);
             return "user/reg3";
        }
        else {
            request.getSession().setAttribute("msgforyanzm", "验证码有误，请重新输入");
            return "user/reg2";
        }
    }

    @RequestMapping("/TestMiyue")
    public  String testmiyue(@RequestParam String miyue, HttpServletRequest request, Model model){
        int miyue_num =userService.findmiyue(miyue);
        if(miyue_num >0){
            return "user/reg2";
        }else {
            request.getSession().setAttribute("msgformiyue", "密钥有误，请重新输入");
            return "user/reg1";
        }
    }
}
