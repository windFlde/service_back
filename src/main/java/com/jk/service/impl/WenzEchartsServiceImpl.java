package com.jk.service.impl;

import com.jk.bean.Lhouse;
import com.jk.mapper.WenzEchartsMapper;
import com.jk.service.WenzEchartsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WenzEchartsServiceImpl implements WenzEchartsService {

    @Resource
    private WenzEchartsMapper wenzEchartsMapper;

    @Override
    public List<Lhouse> getEchartsByCountAuthor() {
        return wenzEchartsMapper.getEchartsByCountAuthor();
    }
}
