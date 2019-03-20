package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.bean.VipInfo;
import com.jk.mapper.VIPMapper;
import com.jk.service.VIPService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VIPServiceImpl implements VIPService {

    @Resource
    VIPMapper vipMapper;

    @Override
    public SendPage queryVIP(ReceivePage receivePage) {
        List<VipInfo> count = vipMapper.queryVIP();
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List<VipInfo> list = vipMapper.queryVIP();
        for (VipInfo vipInfo : list) {
            String info = vipInfo.getInfo();
            String[] split = info.split("//@//%//&//");
            String info2 = split[0]+" || "+split[1];
            if(split.length>2){
                info2 += " || 是 ";
            }else{
                info2 += " || 否 ";
            }
            vipInfo.setInfo(info2);
        }
        SendPage ss = new SendPage(count.size(), list);
        return ss;
    }

    @Override
    public void deleteVIP(String ids) {
        vipMapper.deleteVIP(ids);
    }

    @Override
    public void insertVIP(VipInfo vipInfo) {
        vipMapper.insertVIP(vipInfo);
    }
}
