package com.jk.controller;

import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.bean.ZG;
import com.jk.service.ZGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("zhuanjia")
public class ZGController {

    @Autowired
    ZGService zgService;

    /**
     * 查询
     */
    @ResponseBody
    @RequestMapping("queryZG")
    public SendPage queryZG(ReceivePage receivePage){
        return zgService.queryZG(receivePage);
    }

    /**
     * 回显
     */
    @ResponseBody
    @RequestMapping("queryZGById")
    public ZG queryZGById(String id){
        return zgService.queryZGById(id);
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("updateZG")
    public void updateZG(ZG zg){
        zgService.updateZG(zg);
    }

    /**
     * 删除(批量删)
     */
    @ResponseBody
    @RequestMapping("deleteZG")
    public void deleteZG(String ids){
        zgService.deleteZG(ids);
    }

    /**
     * 新增
     */
    @ResponseBody
    @RequestMapping("addZG")
    public void addZG(ZG zg){
        zgService.addZG(zg);
    }
}
