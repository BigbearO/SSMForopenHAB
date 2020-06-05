package com.xhf.ssmForIDEA.service.impl;

import com.xhf.ssmForIDEA.dao.MiyueDao;
import com.xhf.ssmForIDEA.pojo.Miyue;
import com.xhf.ssmForIDEA.service.MiyueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiyueServiceImpl implements MiyueService {

    @Autowired
    MiyueDao miyueDao;

    @Override
    public List<Miyue> get_miyues() {
        return miyueDao.get_miyues();
    }

    @Override
    public int addmiyue(String miyue) {
        return miyueDao.addmiyue(miyue);
    }

    @Override
    public int updatemiyue(int id, String miyue) {
        return miyueDao.updatemiyue(id, miyue);
    }

    @Override
    public int deletemiyue(int id) {
        return miyueDao.deletemiyue(id);
    }
}
