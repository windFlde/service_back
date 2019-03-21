package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.*;
import com.jk.mapper.XxxMapper;
import com.jk.service.XxxService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class XxxServiceImpl implements XxxService {

    @Resource
    private XxxMapper xxxMapper;

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public SendPage queryWenZhang(WenZhang w, ReceivePage r) {
        List<WenZhang> count = xxxMapper.queryWenZhang(w);
        PageHelper.startPage(r.getPage(),r.getRows());
        List<WenZhang> list = xxxMapper.queryWenZhang(w);
        SendPage ss = new SendPage(count.size(), list);
        return ss;
    }

    @Override
    public void insertWenZhang(WenZhang wenZhang) {
        if (wenZhang.getId()!=null) {
            xxxMapper.updateWenZhang(wenZhang);
        }
        xxxMapper.insertWenZhang(wenZhang);
    }

    @Override
    public void deleteWenZhang(String ids) {
        xxxMapper.deleteWenZhang(ids);
    }

    @Override
    public SendPage queryWenXian(ReceivePage r) {
        List<WenXian> count = xxxMapper.queryWenXian();
        PageHelper.startPage(r.getPage(),r.getRows());
        List<WenXian> list = xxxMapper.queryWenXian();
        SendPage ss = new SendPage(count.size(), list);
        return ss;
    }

    @Override
    public void insertWenXian(WenXian wenZhang) {
        xxxMapper.insertWenXian(wenZhang);
    }

    @Override
    public void deleteWenXian(String ids) {
        xxxMapper.deleteWenXian(ids);
    }

    @Override
    public SendPage getLog(ReceivePage receivePage) {
        Query query = new Query();
        int count = (int) mongoTemplate.count(query, LoginLog.class);
        // skipNum = (pageNow-1)*pageSize

        query.skip((receivePage.getPage() - 1) * receivePage.getRows());

        query.limit(receivePage.getRows());

        List<LoginLog> logList = mongoTemplate.find(query, LoginLog.class);

        SendPage sendPage = new SendPage(count, logList);
        return sendPage;
    }

    @Override
    public WenZhang querySites(WenZhang wenZhang) {
        return xxxMapper.querySites(wenZhang);
    }

    @Override
    public Integer getSites(Integer sites) {
        return xxxMapper.getSites(sites);
    }

    @Override
    public void updateSitesByIntSites(Integer intSites, Integer id, Integer sites) {
        System.out.println("之前"+intSites);
        xxxMapper.updateBeforeSites(intSites,sites);
        System.out.println("之后"+intSites);
        xxxMapper.updateSitesByIntSites(intSites,id);
    }

    @Override
    public Integer getDownSite(Integer sites) {
        return xxxMapper.getDownSite(sites);
    }

    @Override
    public WenZhang toTop(WenZhang wenZhang) {
        return xxxMapper.toTop(wenZhang);
    }


    @Override
    public Integer queryMinSites() {
        return xxxMapper.queryMinSites();
    }


    @Override
    public void updateSitesByMinSites(Integer minSites, Integer id, Integer sites) {
        xxxMapper.updateMinSites(minSites,sites);
        xxxMapper.updateSitesByMinSites(minSites,id);
    }

    @Override
    public void updateBeforeSites(Integer minSites, Integer id,  Integer maxSites) {
        xxxMapper.updateNowSites(maxSites+1,id);
    }

    @Override
    public Integer queryMaxSites() {
        return xxxMapper.queryMaxSites();
    }

    @Override
    public SendPage queryTitleName(ReceivePage receivePage) {
        Query query = new Query();
        int count = (int) mongoTemplate.count(query, TitleName.class);
        // skipNum = (pageNow-1)*pageSize
        query.skip((receivePage.getPage() - 1) * receivePage.getRows());
        query.limit(receivePage.getRows());
        List<TitleName> logList = mongoTemplate.find(query, TitleName.class);
        SendPage sendPage = new SendPage(count, logList);
        return sendPage;
    }

    @Override
    public SendPage queryBlackUser(ReceivePage r) {
        List<BlackUser> count = xxxMapper.queryBlackUser();
        PageHelper.startPage(r.getPage(),r.getRows());
        List<BlackUser> list = xxxMapper.queryBlackUser();
        SendPage ss = new SendPage(count.size(), list);
        return ss;
    }

    @Override
    public void insertBlackUser(BlackUser blackUser) {
        xxxMapper.insertBlackUser(blackUser);
    }

    @Override
    public void deleteBlackUser(String ids) {
        xxxMapper.deleteBlackUser(ids);
    }

    @Override
    public SendPage getUser(ReceivePage r) {
        List<User> count = xxxMapper.getUser();
        PageHelper.startPage(r.getPage(),r.getRows());
        List<User> list = xxxMapper.getUser();
        SendPage ss = new SendPage(count.size(), list);
        return ss;
    }

    @Override
    public Integer queryUserFt(Integer id) {
        return xxxMapper.queryUserFt(id);
    }

    @Override
    public SendPage queryMainTitleName(ReceivePage r) {
        List<MainContent> count = xxxMapper.queryMainTitleName();
        PageHelper.startPage(r.getPage(),r.getRows());
        List<MainContent> list = xxxMapper.queryMainTitleName();
        SendPage ss = new SendPage(count.size(), list);
        return ss;
    }

    @Override
    public void insertMainTitleName(MainContent mainContent) {
        xxxMapper.insertMainTitleName(mainContent);
    }

    @Override
    public void deleteMainItemsGongGao(String ids) {
        xxxMapper.deleteMainItemsGongGao(ids);
    }

    @Override
    public SendPage queryXIaofei(ReceivePage r) {
        List<Redeem> count = xxxMapper.queryXIaofei();
        PageHelper.startPage(r.getPage(),r.getRows());
        List<Redeem> list = xxxMapper.queryXIaofei();
        SendPage ss = new SendPage(count.size(), list);
        return ss;
    }

    @Override
    public void deleteOrder(String ids) {
        xxxMapper.deleteOrder(ids);
    }

    @Override
    public void insertOrder(Redeem u) {
        xxxMapper.insertOrder(u);
    }


}
