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

    List<Integer> getRoleIdByUserId(String userId);

    @Select("select * from t_tree t where pid=#{pid}")
    List<Tree> queryPermission(String id);

    @Select("select * from t_role_permission where roleid= #{roleId}")
    List<Integer> getPermissionIdByRoleId(Integer roleId);
}
