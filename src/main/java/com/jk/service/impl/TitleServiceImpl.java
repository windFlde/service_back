package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.bean.Title;
import com.jk.mapper.TitleMapper;
import com.jk.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleServiceImpl implements TitleService {

    @Autowired
    TitleMapper titleMapper;

    @Override
    public SendPage queryTitle(ReceivePage receivePage) {
        List<Title> count = titleMapper.queryTitle();
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List<Title> list = titleMapper.queryTitle();
        SendPage ss = new SendPage(count.size(), list);
        return ss;
    }

    @Override
    public void deleteTitle(String ids) {
        titleMapper.deleteTitle(ids);
    }

    @Override
    public String insertTitle(Title title) {
          //每个区域最多有5个标题展示
        Integer block = title.getBlock();
       Integer cont = titleMapper.getcot(block);
        if(cont >= 5){
            return "0";
        }else{
            titleMapper.insertTitle(title);
            return "1";
        }
    }

    @Override
    public void updateTitle(String id,Integer state) {
        titleMapper.updateTitle(id,state);
    }
}
