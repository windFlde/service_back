package com.jk.controller;

import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.bean.WenZhang;
import com.jk.service.XxxService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("xjw")
public class XxxController {

    @Resource
    private XxxService xxxService;

    @ResponseBody
    @RequestMapping("queryWenZhang")
    public SendPage queryWenZhang(WenZhang w, ReceivePage receivePage) {
        SendPage list =xxxService.queryWenZhang(w,receivePage);
        return list;
    }
    @ResponseBody
    @RequestMapping("insertWenZhang")
    public String insertWenZhang(WenZhang wenZhang) {
        xxxService.insertWenZhang(wenZhang);
        return "";
    }

    @ResponseBody
    @RequestMapping("deleteWenZhang")
    public void deleteWenZhang(String  ids) {
        xxxService.deleteWenZhang(ids);
    }

}
