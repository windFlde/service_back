package com.jk.controller;

import com.jk.bean.*;
import com.jk.service.BckService;
import com.jk.service.XxxService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
    private MongoTemplate mongoTemplate;


    @Resource
    XxxService xxxService;
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
    @RequestMapping("querySs")
    public SendPage  querySs(ReceivePage receivePage){
        return bckService.querySs(receivePage);
    }

    @ResponseBody
    @RequestMapping("addSs")
    public void  addSs(Sensitivity sensitivity){
        bckService.addSs(sensitivity);
    }

    @ResponseBody
    @RequestMapping("delSs")
    public void delSs(Integer id){
        bckService.delSs(id);
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

    @ResponseBody
    @RequestMapping("quertPingLun")
    public SendPage quertPingLun(ReceivePage receivePage){
       return bckService.quertPingLun(receivePage);
    }

    @ResponseBody
    @RequestMapping("updatePingLun")
    public void updatePingLun(String id,Integer black ){
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Update huifu1 = new Update().set("black",black);
        mongoTemplate.updateFirst(query,huifu1,PingLun.class);
    }
    @ResponseBody
    @RequestMapping("deletePingLun")
    public void deletePingLun(String id){
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        mongoTemplate.remove(query,PingLun.class);
    }
}
