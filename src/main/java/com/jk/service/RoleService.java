package com.jk.service;

import com.jk.bean.QueryParam;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.bean.Tree;

import java.util.List;

public interface RoleService {

    void addRoleByUserId(QueryParam queryParam);

    void removeRoleByUserId(QueryParam queryParam);

    SendPage queryRole(ReceivePage receivePage);

    void addPowerToRole(QueryParam queryParam);

    void deletePermissionToRole(List<Integer> roid);
}
