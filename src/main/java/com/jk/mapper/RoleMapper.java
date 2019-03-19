package com.jk.mapper;

import com.jk.bean.Role;
import com.jk.bean.Tree;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {

    void addRoleByUserId(@Param("userId") Integer userId, @Param("roid") List<Integer> roid);

    void removeRoleByUserId(@Param("userId") Integer userId, @Param("roid") List<Integer> roid);

    List<Role> queryRole();

    @Delete("delete from t_role_permission where roleid = #{roleId}")
    void removePowerByRoleId(Integer roleId);

    void addPowerToRole(@Param("roleId") Integer roleId, @Param("powerId")List<Integer> powerId);

    void deletePermissionToRole(List<Integer> roid);
}
