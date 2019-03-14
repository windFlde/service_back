package com.jk.controller;

import com.jk.bean.Example;
import com.jk.bean.Exprent;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.service.BckService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("bck")
public class BckController {

    @Resource
    BckService bckService;

    @RequestMapping("toPage")
    public String toPage(String name){
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
