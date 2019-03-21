package com.jk.service;

import com.jk.bean.*;

public interface RoleService {
    SendPage queryRole(Role role, ReceivePage receivePage);

    void addRoleByUserId(QueryParam queryParam);

    void removeRoleByUserId(QueryParam queryParam);

    void addPowerToRole(QueryParam queryParam);


    void deletePermissionToRole(Integer roleid);
}
