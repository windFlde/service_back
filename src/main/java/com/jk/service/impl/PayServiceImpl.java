package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.Pay;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.mapper.PayMapper;
import com.jk.service.PayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PayServiceImpl implements PayService {

    @Resource
    PayMapper payMapper;

    @Override
    public SendPage getData(ReceivePage receivePage) {
       List<Pay> count = payMapper.getData();
        PageHelper.startPage(receivePage.getPage(), receivePage.getRows());
        List<Pay> list = payMapper.getData();
        SendPage sendPage = new SendPage(count.size(), list);
        return sendPage;
    }

    @Override
    public Pay updateItem(Integer id) {
        return payMapper.updateItem(id);
    }

    @Override
    public void addData(Pay pay) {
        payMapper.addData(pay);
    }
}
