package com.xhf.ssmForIDEA.controller;


import com.xhf.ssmForIDEA.service.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController {

    @Autowired
    JsonService jsonService;

    @RequestMapping("/savethings")
    @ResponseBody
    public String savethings(){
        //在这里先清空数据库，并且重置自增id为1

       boolean bo= jsonService.thinngstoI_S();

        return (bo)?"yes":"no";
    }

}
