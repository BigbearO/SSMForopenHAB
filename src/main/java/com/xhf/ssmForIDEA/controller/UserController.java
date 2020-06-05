package com.xhf.ssmForIDEA.controller;

import com.xhf.ssmForIDEA.pojo.User;
import com.xhf.ssmForIDEA.service.AlertSevice;
import com.xhf.ssmForIDEA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    AlertSevice alertSevice;

    @RequestMapping("/toIndex")
    public String toIndex() {
        return "index";//"register";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "user/login";
    }

    @RequestMapping("/login")
    public String Login(@RequestParam String name, @RequestParam String pass, HttpServletRequest request, Model model) {
        int boo = userService.login(name, pass);
        if (boo >= 0) {
            User u = new User(name, pass);
            request.getSession().setAttribute("user", u);
            //request.getSession().setAttribute("name", u.getName());
            model.addAttribute("name", u.getName());
            String  re =(boo == 0)?"main":"mainforadmin";
            return re;
        } else {
                if(boo ==-1) {
                    request.getSession().setAttribute("msg", "登录失败，请检查用户名和密码");
                }
                else  {
                    request.getSession().setAttribute("msg", "登录失败，该账户不可用");
                }
                return "user/login";
        }


    }



    @RequestMapping("/quitUser")
    public String quitUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "user/login";
    }

}
