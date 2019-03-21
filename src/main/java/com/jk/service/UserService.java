package com.jk.service;

import com.jk.bean.*;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
    
    SendPage queryUser(Users users, ReceivePage receivePage);

    void addUser(Users user);

    void updateUser(Users user);

    void deleteUser(String[] ids);

    Users editUser(Integer id);

    ArrayList<Role> getAllRole();

    List<TreeTwo> queryTreeByRoleId(QueryParam queryParam);

    List<Integer> getRoleIdByUserId(String id);

    /*List<Tree> queryPermission();*/

    String getPassword(String userName);

    List<User> getuserName();

    List<Role> getUserRole(String loginacct);

    List<TreeTwo> getUserPer(Integer id);
}
