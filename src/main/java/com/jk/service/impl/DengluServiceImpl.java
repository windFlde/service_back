package com.jk.service.impl;

import com.jk.bean.Users;
import com.jk.mapper.DengluMapper;
import com.jk.service.DengluService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DengluServiceImpl implements DengluService {

    @Resource
    private DengluMapper dengluMapper;

    @Override
    public Users login(Users user) {
        return dengluMapper.login(user);
    }

    @Override
    public void addCode(Users users) {
        dengluMapper.addCode(users);
    }

  /*  @Override
    public List<String> getAccessableUrlByUserId(Integer id) {
        return dengluMapper.getAccessableUrlByUserId(id);
    }*/
}
