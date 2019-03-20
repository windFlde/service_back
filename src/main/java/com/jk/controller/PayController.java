package com.jk.controller;

import com.jk.bean.Pay;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("pay")
public class PayController {

    @Autowired
    PayService payService;

    @ResponseBody
    @RequestMapping("getData")
    public SendPage getData(ReceivePage receivePage) {
        return payService.getData(receivePage);
    }


    @ResponseBody
    @RequestMapping("updateItem")
    public Pay updateItem(Integer id) {
        return payService.updateItem(id);
    }

    @ResponseBody
    @RequestMapping("addData")
    public void addData(Pay pay) {
        payService.addData(pay);
    }
}
