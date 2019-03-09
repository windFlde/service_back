package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.bean.WenZhang;
import com.jk.mapper.XxxMapper;
import com.jk.service.XxxService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class XxxServiceImpl implements XxxService {

    @Resource
    private XxxMapper xxxMapper;


    @Override
    public SendPage queryWenZhang(WenZhang w, ReceivePage r) {
        List<WenZhang> count = xxxMapper.queryWenZhang(w);
        PageHelper.startPage(r.getPage(),r.getRows());
        List<WenZhang> list = xxxMapper.queryWenZhang(w);
        SendPage ss = new SendPage(count.size(), list);
        return ss;
    }

    @Override
    public void insertWenZhang(WenZhang wenZhang) {
        if (wenZhang.getId()!=null) {
            xxxMapper.updateWenZhang(wenZhang);
        }
        xxxMapper.insertWenZhang(wenZhang);
    }

    @Override
    public void deleteWenZhang(String ids) {
        xxxMapper.deleteWenZhang(ids);
    }

}
