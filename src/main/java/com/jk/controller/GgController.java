package com.jk.controller;

import com.jk.bean.Advert;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.service.GgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("gg")
public class GgController {

    @Autowired
    GgService ggService;

    @ResponseBody
    @RequestMapping("getData")
    public SendPage getData(ReceivePage receivePage) {

        SendPage sendPage = ggService.getData(receivePage);
        return sendPage;
    }

    @ResponseBody
    @RequestMapping("addData")
    public void addData(Advert advert) {
        ggService.addData(advert);
    }

    @ResponseBody
    @RequestMapping("deleteItemsById")
    public void deleteItemsById(Integer id) {

        ggService.deleteItemsById(id);

    }
}
