package com.jk.service.impl;

import com.jk.bean.ListData;
import com.jk.mapper.BarChartsMapper;
import com.jk.service.BarChartsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BarChartsServiceImpl implements BarChartsService {

    @Resource
    BarChartsMapper barChartsMapper;

    @Override
    public List<ListData> getEchart() {
        return barChartsMapper.getEchart();
    }

    @Override
    public List<ListData> getVIP() {
        return barChartsMapper.getVIPData();
    }

    @Override
    public List<ListData> getWZData() {
        return barChartsMapper.getWZData();
    }

    @Override
    public List<ListData> getWXData() {
        return barChartsMapper.getWXData();
    }
}
