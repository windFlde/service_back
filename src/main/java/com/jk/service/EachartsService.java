package com.jk.service;

import com.jk.bean.Echarts;
import com.jk.bean.PingLunTwo;

import java.util.ArrayList;
import java.util.List;

public interface EachartsService {


    List<Echarts> queryEcharts();

    void updateItme(PingLunTwo pingLunTwo);

    void delete(String id);

    ArrayList<Echarts> queryEcharts2();


}
