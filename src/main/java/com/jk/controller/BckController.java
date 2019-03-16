package com.jk.controller;

import com.jk.bean.Example;
import com.jk.bean.Exprent;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.service.BckService;
import com.jk.service.XxxService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("bck")
public class BckController {

    @Resource
    BckService bckService;

    @Resource
    XxxService xxxService;
    @RequestMapping("toPage")
    public String toPage(String name, HttpSession session){
        return name;
    }

    @ResponseBody
    @RequestMapping("addEx")
    public void  addEx(Example example){

        bckService.addEx(example);

    }



    @ResponseBody
    @RequestMapping("queryEx")
    public SendPage queryEx(ReceivePage receivePage){
        return bckService.queryEx(receivePage);
    }

    @ResponseBody
    @RequestMapping("quertAu")
    public List<Exprent> quertAu(){
        return bckService.quertAu();
    }

    @ResponseBody
    @RequestMapping("getEx")
    public Example getEx(Integer id){
        return bckService.getEx(id);
    }

    @ResponseBody
    @RequestMapping("delEx")
    public void delEx(String ids){
        bckService.delEx(ids);
    }

}
