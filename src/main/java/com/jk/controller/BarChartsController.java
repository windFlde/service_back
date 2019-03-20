package com.jk.controller;

import com.jk.bean.BarBean;
import com.jk.bean.BarSeries;
import com.jk.bean.ListData;
import com.jk.service.BarChartsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("chart")
public class BarChartsController {

    @Resource
    BarChartsService barChartsService;

    @ResponseBody
    @RequestMapping("getChart")
    public BarBean getChart(){
        BarBean barBean = new BarBean();
        //标题
        barBean.setText("全年用户注册情况");
        barBean.setSubtext("数据纯属虚构");

        //总数据
        List<ListData> list = barChartsService.getEchart();

        List<String> arrayList = new ArrayList<>();
        List<String> arrayList2 = new ArrayList<>();

        for (ListData listData : list) {
            String value = listData.getValue();
            arrayList.add(value);
            String name = listData.getName();
            arrayList2.add(name);
        }
        //横座轴数据
        barBean.setXaxisData(arrayList);

        BarSeries barSeries = new BarSeries();
        barSeries.setName("注册量");
        barSeries.setType("line");
        barSeries.setData(arrayList2);

        List<BarSeries> asd = new ArrayList<>();
        asd.add(barSeries);

        barBean.setSeries(asd);
        return barBean;
    }
}
