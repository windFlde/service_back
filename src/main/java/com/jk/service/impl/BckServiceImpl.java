package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.Example;
import com.jk.bean.Exprent;
import com.jk.bean.ReceivePage;
import com.jk.mapper.BckMapper;
import com.jk.service.BckService;
import com.jk.bean.Exprent;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BckServiceImpl implements BckService {


    @Resource
    BckMapper bckMapper;

    @Override
    public void addEx(Example example) {

        if(example.getId()!=null){
            bckMapper.updateEx();
        }else {
            bckMapper.addEx();
        }


    }

    @Override
    public List<Example> queryEx(ReceivePage receivePage) {
        List <Example> sum = bckMapper.queryEx(); //计算数据库符合条件的总条数 条数是固
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List <Example> list = bckMapper.queryEx(); //当前页面数据 其大小取决于 每页多少条
        return list;
    }

    @Override
    public List<Exprent> quertAu() {
        return bckMapper.quertAu();
    }

}
