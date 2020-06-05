package com.xhf.ssmForIDEA.controller;


import com.xhf.ssmForIDEA.service.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class JsonController {

    @Autowired
    JsonService jsonService;

    String s="C:\\Users\\xhf\\Desktop\\openhab\\openhab-2.5.4\\userdata\\jsondb";
    @RequestMapping("/savethings")
    @ResponseBody
    public String savethings() throws IOException {
        //在这里先清空数据库，并且重置自增id为1

       boolean bo= jsonService.itemtodatabase();

        return (bo)?"yes":"no";
    }

}
