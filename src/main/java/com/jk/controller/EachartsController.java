package com.jk.controller;

import com.jk.bean.Echarts;
import com.jk.service.EachartsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
}
