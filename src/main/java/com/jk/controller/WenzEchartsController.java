package com.jk.controller;

import com.jk.bean.Lhouse;
import com.jk.service.WenzEchartsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("echWenzhang")
public class WenzEchartsController {

    @Resource
    private WenzEchartsService wenzEchartsService;

    @ResponseBody
    @RequestMapping("getEchartsByCountAuthor")
    public Map<String, Object> getEchartsByCountAuthor() {
        Map<String, Object> param = new HashMap<>();

        ArrayList<String> a = new ArrayList<>();

        ArrayList<Integer> b = new ArrayList<>();

        List<Lhouse> house = wenzEchartsService.getEchartsByCountAuthor();

        for (Lhouse lhouse : house) {
            a.add(lhouse.getUserMch());
            b.add(Integer.valueOf(lhouse.getCountMch()));
        }

        param.put("categories", a);
        param.put("data", b);
        System.out.println(param);
        return param;
    }




}
