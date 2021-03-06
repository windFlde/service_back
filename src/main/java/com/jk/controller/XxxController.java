package com.jk.controller;

import com.jk.bean.*;
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
    public String toView(String v,HttpSession session) {
        return v;
    }

    @ResponseBody
    @RequestMapping("insertTitleName")
    public String insertTitleName(TitleName titleName) {
        TitleName titleName1=new TitleName(null,titleName.getTitleContent());
        mongoTemplate.save(titleName1);
        return "1";
    }
    @ResponseBody
    @RequestMapping("queryTitleName")
    public SendPage queryTitleName(ReceivePage receivePage) {
        SendPage list= xxxService.queryTitleName(receivePage);
        return list;
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
            //不为空去后台修改最小值的sites段 和 要置顶的字段
            xxxService.updateSitesByMinSites(minSites,wenz.getId(),wenz.getSites());
            return "wenzSitesFtIsOk";
        }
    }
    @ResponseBody
    @RequestMapping("backTop")
    public String backTop(WenZhang wenZhang,HttpSession session) {
            WenZhang wenz=xxxService.toTop(wenZhang);
            //查询出最小的sites
            Integer minSites=xxxService.queryMinSites();
            Integer maxSites=xxxService.queryMaxSites();
            xxxService.updateBeforeSites(minSites,wenZhang.getId(),maxSites);
            return "backTopOk";

    }
    @ResponseBody
    @RequestMapping("queryBlackUser")
    public SendPage queryBlackUser(ReceivePage receivePage) {
        SendPage sp=xxxService.queryBlackUser(receivePage);
        return sp;
    }
    @ResponseBody
    @RequestMapping("insertBlackUser")
    public String insertBlackUser(BlackUser  blackUser) {
        xxxService.insertBlackUser(blackUser);
        return "1";
    }
    @ResponseBody
    @RequestMapping("deleteBlackUser")
    public void deleteBlackUser(String ids) {
        xxxService.deleteBlackUser(ids);
    }
    @ResponseBody
    @RequestMapping("getUser")
    public SendPage getUser(ReceivePage receivePage) {
        SendPage sp=xxxService.getUser(receivePage);
        return sp;

    }
    @ResponseBody
    @RequestMapping("insertById")
    public String insertById(User user) {
        BlackUser blackUser = new BlackUser();
        Integer count=xxxService.queryUserFt(user.getId());
        if (count>0) {
            return "0";
        }
        blackUser.setLoginacct(user.getLoginacct());
        blackUser.setUserId(user.getId());
        blackUser.setName(user.getUsername());
        xxxService.insertBlackUser(blackUser);
        return "1";
    }
    @ResponseBody
    @RequestMapping("deleteItemsGongGao")
    public void deleteItemsGongGao(String ids) {
        TitleName titleName = new TitleName();
        titleName.setId(ids);
        mongoTemplate.remove(titleName);
    }
    @ResponseBody
    @RequestMapping("queryMainTitleName")
    public SendPage queryMainTitleName(ReceivePage receivePage) {
        SendPage sp=xxxService.queryMainTitleName(receivePage);
        return sp;
    }

    @ResponseBody
    @RequestMapping("insertMainTitleName")
    public String insertMainTitleName(MainContent mainContent) {
        xxxService.insertMainTitleName(mainContent);
        return "";
    }

    @ResponseBody
    @RequestMapping("deleteMainItemsGongGao")
    public void deleteMainItemsGongGao(String ids) {
        xxxService.deleteMainItemsGongGao(ids);
    }

    @ResponseBody
    @RequestMapping("queryXIaofei")
    public SendPage queryXIaofei(ReceivePage receivePage) {
        SendPage sp=xxxService.queryXIaofei(receivePage);
        return sp;
    }

    @ResponseBody
    @RequestMapping("deleteOrder")
    public void deleteOrder(String ids) {
        xxxService.deleteOrder(ids);
    }
    @ResponseBody
    @RequestMapping("insertOrder")
    public String insertOrder(Redeem u) {
        xxxService.insertOrder(u);
        return "";
    }

}
