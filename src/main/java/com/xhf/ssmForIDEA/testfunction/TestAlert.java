package com.xhf.ssmForIDEA.testfunction;

import com.xhf.ssmForIDEA.util.MyUtil;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TestAlert {

    //注意这个注解不能写在方法里面，只能在外面
    @Value("#{prop.path}")
    String s;
    public static void main(String[] args) {

            String s1 = MyUtil.timeto("01:02:03","06:08:09");
            String s2 =MyUtil.timeto2("01:02:03","06:08:09");
            System.out.println(s1);
            System.out.println("--------___fejx");
            System.out.println(s2);
            System.out.println("--------___fejx");
            //System.out.println(new TestAlert().s);
    }


}
