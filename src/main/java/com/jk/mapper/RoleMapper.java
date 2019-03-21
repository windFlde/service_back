package com.jk.mapper;

import com.jk.bean.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {

    void addRoleByUserId(@Param("userid") Integer userid, @Param("roid") List<Integer> roid);

    void removeRoleByUserId(@Param("userid") Integer userid, @Param("roid") List<Integer> roid);

    List<Role> queryRole(Role role);

    void addPowerToRole(@Param("rid") Integer roleid, @Param("powerId") List<Integer> powerId);

    void deletePermissionToRole(Integer roleid);


}
