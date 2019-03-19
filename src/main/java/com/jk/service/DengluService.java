package com.jk.service;

import com.jk.bean.User;
import com.jk.bean.Users;

public interface DengluService {

    Users login(Users user);

    void addCode(Users users);
}
