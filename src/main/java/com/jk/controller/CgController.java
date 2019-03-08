package com.jk.controller;

import com.jk.bean.Chuangguan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("CG")
public class CgController {

    @Resource
    MongoTemplate mongoTemplate;

    @ResponseBody
    @RequestMapping("addChuangGuan")
    public String addChuangGuan(Chuangguan chuangguan) {
        String answer = chuangguan.getAnswer1()+","+chuangguan.getAnswer2()+","+chuangguan.getAnswer3()+","+chuangguan.getAnswer4();
        chuangguan.setAnswer(answer);
        mongoTemplate.save(chuangguan);
        return "";
    }


}
