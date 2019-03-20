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

    /**
     * 查询用户注册信息
     */
    @ResponseBody
    @RequestMapping("getChart")
    public BarBean getChart(){

        //标题
        String title = "全年用户注册情况";
        String futitle = "数据纯属虚构";
        //图例
        String tuli = "注册量";
        //图示  线形 line  柱形 bar
        String type = "line";
        //总数据
        List<ListData> list = barChartsService.getEchart();
        BarBean asd = asd(list, title, futitle,tuli,type);
        return asd;
    }

    /**
     * VIP开通信息
     */
    @ResponseBody
    @RequestMapping("getVIP")
    public BarBean getVIP(){
        //标题
        String title = "全年用户VIP开通情况";
        String futitle = "数据纯属虚构";
        //图例
        String tuli = "开通数";
        //图示  线形 line  柱形 bar
        String type = "bar";
        //总数据
        List<ListData> list = barChartsService.getVIP();
        BarBean asd = asd(list, title, futitle,tuli,type);
        return asd;
    }

    /**
     *文章点击量情况
     */
    @ResponseBody
    @RequestMapping("getWZData")
    public BarBean getWZData(){
        //标题
        String title = "文章点击流量详情";
        String futitle = "数据纯属虚构";
        //图例
        String tuli = "点击量";
        //图示  线形 line  柱形 bar
        String type = "line";
        //总数据
        List<ListData> list = barChartsService.getWZData();
        BarBean asd = asd(list, title, futitle,tuli,type);
        return asd;
    }

    /**
     *全年文献发表情况
     */
    @ResponseBody
    @RequestMapping("getWXData")
    public BarBean getWXData(){
        //标题
        String title = "全年文献发表情况";
        String futitle = "数据纯属虚构";
        //图例
        String tuli = "发表量";
        //图示  线形 line  柱形 bar
        String type = "bar";
        //总数据
        List<ListData> list = barChartsService.getWXData();
        BarBean asd = asd(list, title, futitle,tuli,type);
        return asd;
    }

    public BarBean asd(List<ListData> list,String title,String futitle,String tuli,String type){
        BarBean barBean = new BarBean();
        //标题
        barBean.setText(title);
        barBean.setSubtext(futitle);
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

        //图例
        barSeries.setName(tuli);
        //图示 line  bar
        barSeries.setType(type);

        barSeries.setData(arrayList2);
        List<BarSeries> asd = new ArrayList<>();
        asd.add(barSeries);
        barBean.setSeries(asd);
        return barBean;
    }
}
