package com.xhf.ssmForIDEA.service;

import com.xhf.ssmForIDEA.pojo.Miyue;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MiyueService {

    List<Miyue> get_miyues();

    int addmiyue( String miyue);

    int updatemiyue(int id, String miyue);

    int deletemiyue(int id);
}
