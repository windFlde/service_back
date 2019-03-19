package com.jk.mapper;

import com.jk.bean.*;
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

    @Select("select * from t_tree  where pid=#{id}")
    List<Tree> queryPermission(String id);

    @Select("select permissionid from t_role_permission where roleid= #{roleid}")
    List<Integer> getPermissionIdByRoleId(Integer roleid);

    List<Integer> getRoleIdByUserId(String id);



}
