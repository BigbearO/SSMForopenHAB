package com.xhf.ssmForIDEA.service.impl;

import com.xhf.ssmForIDEA.service.AlertSevice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class AlertServiceImpl implements AlertSevice {

    @Value("${rulespath")
     String rulespath;

    String path =rulespath+"alert.rules";
    @Override
    public boolean changemailAdress(String mailadress) {
            try {
                List<String> lines = Files.readAllLines(Paths.get(path));
                //System.out.println(lines);
                lines.set(0,"var mailadress=\""+mailadress+"\"");
                // System.out.println(lines);
                Files.write(Paths.get(path), lines);
            } catch (IOException e) {
                System.out.println("未找到报警规则文件");
                e.printStackTrace();
            }


        return false;
    }
}
