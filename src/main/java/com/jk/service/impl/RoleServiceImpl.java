package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.*;
import com.jk.mapper.RoleMapper;
import com.jk.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    //====给用户赋角色
    @Override
    public void addRoleByUserId(QueryParam queryParam) {

        roleMapper.addRoleByUserId(queryParam.getUserid(),queryParam.getRoid());
    }

    //=====移除角色
    @Override
    public void removeRoleByUserId(QueryParam queryParam) {
        roleMapper.removeRoleByUserId(queryParam.getUserid(),queryParam.getRoid());
    }

    @Override
    public SendPage queryRole(ReceivePage receivePage) {
        List<Role> count=roleMapper.queryRole();
        PageHelper.startPage(receivePage.getPage(), receivePage.getRows());
        List<Role> list=roleMapper.queryRole();
        SendPage sendPage = new SendPage(count.size(),list);
        return sendPage;
    }


    //===给用户赋权限
    @Override
    public void addPowerToRole(QueryParam queryParam) {


        roleMapper.addPowerToRole(queryParam.getRoleid(),queryParam.getPowerId());
    }

    @Override
    public void deletePermissionToRole(Integer roleid) {
        roleMapper.deletePermissionToRole(roleid);
    }


}
