package com.xhf.ssmForIDEA.service.impl;

import com.xhf.ssmForIDEA.dao.AdminDao;
import com.xhf.ssmForIDEA.pojo.User_admin;
import com.xhf.ssmForIDEA.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;

    @Override
    public int changeUser_useable(int id, String useable) {
        System.out.print("id结果是："+id+""+useable);
        System.out.print("use结果是："+useable);
        String newuse = useable.equals("1")?"0":"1";
        System.out.print("结果是："+newuse);
        int i = Integer.parseInt(newuse);
        int result =adminDao.changeUser_useable(id,i);
        return result;
    }

    @Override
    public List<User_admin> getusers() {
        return adminDao.getusers();
    }
}
