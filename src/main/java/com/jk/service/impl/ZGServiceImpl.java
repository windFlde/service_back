package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.bean.ZG;
import com.jk.mapper.ZGMapper;
import com.jk.service.ZGService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ZGServiceImpl implements ZGService {

    @Autowired
    ZGMapper zgMapper;

    @Override
    public SendPage queryZG(ReceivePage receivePage) {
        List<ZG> count = zgMapper.queryZG();
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List<ZG> list = zgMapper.queryZG();
        SendPage ss = new SendPage(count.size(), list);
        return ss;
    }

    @Override
    public ZG queryZGById(String id) {
        return zgMapper.queryZGById(id);
    }

    @Override
    public void updateZG(ZG zg) {
        zgMapper.updateZG(zg);
    }

    @Override
    public void deleteZG(String ids) {
        zgMapper.deleteZG(ids);
    }

    @Override
    public void addZG(ZG zg) {
        zgMapper.addZG(zg);
    }
}
