package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.Advert;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.mapper.GgMapper;
import com.jk.service.GgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GgServiceImpl implements GgService {

    @Resource
    GgMapper ggMapper;

    @Override
    public SendPage getData(ReceivePage receivePage) {

       List<Advert> count = ggMapper.getData();
        PageHelper.startPage(receivePage.getPage(), receivePage.getRows());
        List<Advert> list = ggMapper.getData();
        SendPage sendPage = new SendPage(count.size(), list);
        return sendPage;
    }

    @Override
    public void addData(Advert advert) {
        ggMapper.addData(advert);
    }

    @Override
    public void deleteItemsById(Integer id) {
        ggMapper.deleteItemsById(id);

    }
}
