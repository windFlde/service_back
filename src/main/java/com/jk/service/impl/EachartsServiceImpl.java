package com.jk.service.impl;

import com.jk.bean.Echarts;
import com.jk.bean.PingLunTwo;
import com.jk.mapper.EachartsMapper;
import com.jk.service.EachartsService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class EachartsServiceImpl implements EachartsService {

    @Resource
    private EachartsMapper eachartsMapper;

    @Resource
    MongoTemplate mongoTemplate;


    @Override
    public List<Echarts> queryEcharts() {

        Query queryB = new Query();
        queryB.addCriteria(Criteria.where("name").is("马云"));
        int countB = (int) mongoTemplate.count(queryB, PingLunTwo.class);

        Query queryC = new Query();
        queryC.addCriteria(Criteria.where("name").is("刘强东"));
        int countC = (int) mongoTemplate.count(queryC, PingLunTwo.class);

        Query queryD = new Query();
        queryD.addCriteria(Criteria.where("name").is("雷军"));
        int countD = (int) mongoTemplate.count(queryD, PingLunTwo.class);

        Query queryE = new Query();
        queryE.addCriteria(Criteria.where("name").is("任正非"));
        int countE = (int) mongoTemplate.count(queryE, PingLunTwo.class);





        List<Echarts> echarts = new ArrayList<>();
        if(countB>0){
            echarts.add(new Echarts(countB,"马云"));
        }
        if(countC>0){
            echarts.add(new Echarts(countC,"刘强东"));
        }
        if(countD>0){
            echarts.add(new Echarts(countD,"雷军"));
        }
        if(countE>0){
            echarts.add(new Echarts(countE,"任正非"));
        }

        return echarts;
    }

    @Override
    public void updateItme(PingLunTwo pingLunTwo) {

        mongoTemplate.save(pingLunTwo);

    }

    @Override
    public void delete(String id) {
        PingLunTwo pingLunTwo = new PingLunTwo();
        pingLunTwo.set_id(id);
        mongoTemplate.remove(pingLunTwo);
    }

    @Override
    public ArrayList<Echarts> queryEcharts2() {
        return eachartsMapper.queryEcharts2();
    }


}
