package com.jk.service;

import com.jk.bean.*;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
    
    SendPage queryUser(ReceivePage receivePage);

    void addUser(Users user);

    void updateUser(Users user);

    void deleteUser(String[] ids);

    Users editUser(Integer id);

    ArrayList<Role> getAllRole();

    List<Tree> queryTreeByRoleId(QueryParam queryParam);

    List<Integer> getRoleIdByUserId(String id);
}
