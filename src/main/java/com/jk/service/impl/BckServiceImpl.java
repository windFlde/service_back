package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.*;
import com.jk.mapper.BckMapper;
import com.jk.service.BckService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BckServiceImpl implements BckService {


    @Resource
    BckMapper bckMapper;

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void addEx(Example example) {

        if(example.getId()!=null){
            bckMapper.updateEx(example.getId());
        }else {
            bckMapper.addEx(example);
        }


    }

    @Override
    public SendPage queryEx(ReceivePage receivePage) {
        List <Example> sum = bckMapper.queryEx(); //计算数据库符合条件的总条数 条数是固
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List <Example> list = bckMapper.queryEx(); //当前页面数据 其大小取决于 每页多少条
        SendPage sendPage = new SendPage(sum.size(),list);
        return sendPage;
    }

    @Override
    public List<Exprent> quertAu() {
        return bckMapper.quertAu();
    }

    @Override
    public Example getEx(Integer id) {
        return bckMapper.getEx(id);
    }

    @Override
    public void delEx(String idS) {
        bckMapper.delEx(idS);
    }

    @Override
    public SendPage querySs(ReceivePage receivePage) {
        List <Sensitivity> sum = bckMapper.querySs(); //计算数据库符合条件的总条数 条数是固
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List <Sensitivity> list = bckMapper.querySs(); //当前页面数据 其大小取决于 每页多少条
        SendPage sendPage = new SendPage(sum.size(),list);
        return sendPage;
    }

    @Override
    public void addSs(Sensitivity sensitivity) {
        bckMapper.addSs(sensitivity);
    }

    @Override
    public void delSs(Integer id) {
        bckMapper.delSs(id);
    }


    public SendPage quertPingLun(ReceivePage receivePage) {
        Query query = new Query();
        int count = (int) mongoTemplate.count(query, PingLun.class);
        // skipNum = (pageNow-1)*pageSize

        query.skip((receivePage.getPage() - 1) * receivePage.getRows());

        query.limit(receivePage.getRows());

        List<PingLun> pingLunList = mongoTemplate.find(query, PingLun.class);

        SendPage sendPage = new SendPage(count, pingLunList);
        return sendPage;
    }

    @Override
    public void updatePay(Integer id, Integer pay) {
        bckMapper.updatePay(id,pay);
    }

}
