package com.xhf.ssmForIDEA.service;

import com.xhf.ssmForIDEA.pojo.User;
import com.xhf.ssmForIDEA.pojo.User_admin;

import java.util.List;

public interface AdminService {
    int  changeUser_useable(int id,String useable);
    List<User_admin> getusers();
}
