package com.jk.controller;

import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.bean.WenXian;
import com.jk.bean.WenZhang;
import com.jk.service.XxxService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("xjw")
public class XxxController {

    @Resource
    private XxxService xxxService;

    @Resource
    private MongoTemplate mongoTemplate;

    @RequestMapping("toView")
    public String toView(String v) {
        return v;
    }

    @ResponseBody
    @RequestMapping("queryWenZhang")
    public SendPage queryWenZhang(WenZhang w, ReceivePage receivePage) {
        SendPage list =xxxService.queryWenZhang(w,receivePage);
        return list;
    }
    @ResponseBody
    @RequestMapping("queryWenXian")
    public SendPage queryWenXian(ReceivePage receivePage) {
        SendPage list =xxxService.queryWenXian(receivePage);
        return list;
    }
    @ResponseBody
    @RequestMapping("insertWenZhang")
    public String insertWenZhang(WenZhang wenZhang) {
        Integer maxSites=xxxService.queryMaxSites();
        wenZhang.setSites(maxSites+1);
        xxxService.insertWenZhang(wenZhang);
        return "";
    }
    @ResponseBody
    @RequestMapping("insertWenXian")
    public String insertWenXian(WenXian wenZhang) {
        xxxService.insertWenXian(wenZhang);
        return "";
    }

    @ResponseBody
    @RequestMapping("deleteWenZhang")
    public void deleteWenZhang(String  ids) {
        xxxService.deleteWenZhang(ids);
    }
    @ResponseBody
    @RequestMapping("deleteWenXian")
    public void deleteWenXian(String  ids) {
        xxxService.deleteWenXian(ids);
    }
    @ResponseBody
    @RequestMapping("getLog")
    public SendPage getLog(ReceivePage receivePage) {
        SendPage sendPage=xxxService.getLog(receivePage);
        return sendPage;
    }
    //上移
    @ResponseBody
    @RequestMapping("upSites")
    public String upSites(WenZhang wenZhang) {
        WenZhang wenz=xxxService.querySites(wenZhang);
        Integer intSites=xxxService.getSites(wenz.getSites());
        if (intSites==null) {
            return "intSitesFail";
        }else{
            xxxService.updateSitesByIntSites(intSites,wenz.getId(),wenz.getSites());
            return "intSitesOk";
        }
    }
    //下移
    @ResponseBody
    @RequestMapping("downSites")
    public String downSites(WenZhang wenZhang) {
        WenZhang wenz=xxxService.querySites(wenZhang);
        Integer downSites=xxxService.getDownSite(wenz.getSites());
        if (downSites==null) {
            return "downSitesFail";
        }else{
            xxxService.updateSitesByIntSites(downSites,wenz.getId(),wenz.getSites());
            return "downSitesOk";
        }
    }

    //置顶
    @ResponseBody
    @RequestMapping("toTop")
    public String toTop(WenZhang wenZhang, HttpSession session) {
        WenZhang wenz=xxxService.toTop(wenZhang);
        //获取一下数据库中的sites值
        Integer wenzSites=wenz.getSites();
        //查询出最小的sites
        Integer minSites=xxxService.queryMinSites();

        if (minSites==wenzSites) {
            return "wenzSitesFtisExsits";
        } else {
            //将现在的sites存入session 取消置顶时使用
            session.setAttribute("beforeSites",wenzSites);
            //不为空去后台修改最小值的sites段 和 要置顶的字段
            xxxService.updateSitesByMinSites(minSites,wenz.getId(),wenz.getSites());
            return "wenzSitesFtIsOk";
        }
    }
    @ResponseBody
    @RequestMapping("backTop")
    public String backTop(Integer id,Integer sitesVal,HttpSession session) {
        //查询出最小的sites
        Integer minSites=xxxService.queryMinSites();
        if (sitesVal==null) {
            return "backTopNo";
        }else{
            //siewsVal为作用域中存入的sites
            xxxService.updateBeforeSites(minSites,id,sitesVal);
            session.removeAttribute("beforeSites");
            return "backTopOk";

        }
    }


}
