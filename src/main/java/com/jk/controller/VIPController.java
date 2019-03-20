package com.jk.controller;

import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.bean.VipInfo;
import com.jk.service.VIPService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("vip")
public class VIPController {

    @Resource
    VIPService vipService;

    /**
     * 查询vip
     */
    @ResponseBody
    @RequestMapping("queryVIP")
    public SendPage queryVIP(ReceivePage receivePage){
        return vipService.queryVIP(receivePage);
    }

    /**
     * 删除Vip
     */
    @ResponseBody
    @RequestMapping("deleteVIP")
    public void deleteVIP(String ids){
        vipService.deleteVIP(ids);
    }

    /**
     * 新增Vip
     */
    @ResponseBody
    @RequestMapping("insertVIP")
    public void insertVIP(VipInfo vipInfo){
        String info = vipInfo.getInfo1()+"//@//%//&//"+vipInfo.getInfo2();
        if(vipInfo.getInfo3().equals("1")){
            info += "//@//%//&//1";
        }
        vipInfo.setInfo(info);
        vipService.insertVIP(vipInfo);
    }

}
