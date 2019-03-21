package com.jk.controller;

import com.jk.bean.Echarts;
import com.jk.bean.PingLunTwo;
import com.jk.service.EachartsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EachartsController {

    @Resource
    private EachartsService eachartsService;

    @RequestMapping("queryEcharts")
    public List<Echarts> queryEcharts() {

        List<Echarts>  echarts=eachartsService.queryEcharts();
        return echarts;

    }

    @RequestMapping("update")
    public String updateItme(PingLunTwo pingLunTwo) {

        eachartsService.updateItme(pingLunTwo);
        return "success";
    }

    @RequestMapping("delete")
    public String delete(String id) {


        eachartsService.delete(id);
        return "success";
    }

    @RequestMapping("queryEcharts2")
    public ArrayList<Echarts> queryEcharts2() {

        ArrayList<Echarts> list=eachartsService.queryEcharts2();
        return list;
    }
}
