package com.jk.mapper;

import com.jk.bean.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;

public interface UserMapper {

    List<User> queryUser();

    void addUser(Users user);

    void updateUser(Users user);

    void deleteUser(String[] ids);

    Users editUser(Integer id);

    ArrayList<Role> getAllRole();

    List<Integer> getRoleIdByUserId(String id);

    @Select("select permissionid as pid from t_role_permission where roleid= #{roleid}")
    List<Integer> getPermissionIdByRoleId(Integer roleid);

    @Select("select * from t_tree2  where pid=#{id}")
    List<TreeTwo> queryPermission(int id);


    String getPassword(String userName);

    List<User> getuserName();

    List<Role> getUserRole(String loginacct);

    List<TreeTwo> getUserPer(Integer id);
}
