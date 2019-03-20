package com.jk.service;

import com.jk.bean.User;
import com.jk.bean.Users;

import java.util.List;

public interface DengluService {

    Users login(Users user);

    void addCode(Users users);

    /*List<String> getAccessableUrlByUserId(Integer id);*/
}
