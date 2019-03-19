package com.jk.service;

import com.jk.bean.QueryParam;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.bean.Tree;

import java.util.List;

public interface RoleService {
    SendPage queryRole(ReceivePage receivePage);

    void addRoleByUserId(QueryParam queryParam);

    void removeRoleByUserId(QueryParam queryParam);

    void addPowerToRole(QueryParam queryParam);


    void deletePermissionToRole(Integer roleid);
}
