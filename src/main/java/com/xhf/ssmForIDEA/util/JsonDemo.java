package com.xhf.ssmForIDEA.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xhf.ssmForIDEA.pojo.Thing;
import com.xhf.ssmForIDEA.testfunction.DomainDemo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.util.*;

public class JsonDemo {

    @Value("#{prop.path}")
    String s;

    public static void main(String[] args) {

    }
}
