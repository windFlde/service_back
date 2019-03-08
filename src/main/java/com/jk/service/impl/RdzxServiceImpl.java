package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.Hotspot;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.mapper.RdzxMapper;
import com.jk.service.RdzxService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RdzxServiceImpl  implements RdzxService {

    @Resource
    private RdzxMapper rdzxMapper;

    @Override
    public SendPage queryRdzx(Hotspot hotspot, ReceivePage receivePage) {


        List<Hotspot> count=rdzxMapper.queryRdzx(hotspot);
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List<Hotspot> list = rdzxMapper.queryRdzx(hotspot);
        SendPage sendPage = new SendPage(count.size(),list);
        return sendPage;

    }

    @Override
    public void deleteHosport(String[] ids) {
        rdzxMapper.deleteHosport(ids);
    }

    @Override
    public void addHotspot(Hotspot hotspot) {
        rdzxMapper.addHotspot(hotspot);
    }

    @Override
    public void updateHotspot(Hotspot hotspot) {

        rdzxMapper.updateHotspot(hotspot);
    }

    @Override
    public Hotspot editHotspot(Hotspot hotspot) {
        return rdzxMapper.rdzxMapper(hotspot);
    }
}
