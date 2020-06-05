package com.xhf.ssmForIDEA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @RequestMapping("/toz")
    public String toz() {
        return "zidingyi";//"register";
    }

    @RequestMapping("/toreg3")
    public String tore() {
        return "user/reg3";//"register";
    }

    @RequestMapping("/totest")
    public String totest(Model model) {
        model.addAttribute("test","测试的内容呀");
        return "test/test";//"register";
    }

    @RequestMapping("/test")
    public String test() {
        return "test/test";
    }//页面返回后，不会保存model的值



}
