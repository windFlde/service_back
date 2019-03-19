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

    @Override
    public void addRoleByUserId(QueryParam queryParam) {

        roleMapper.addRoleByUserId(queryParam.getUserId(), queryParam.getRoid());
    }

    @Override
    public void removeRoleByUserId(QueryParam queryParam) {
        roleMapper.removeRoleByUserId(queryParam.getUserId(),queryParam.getRoid());
    }

    @Override
    public SendPage queryRole(ReceivePage receivePage) {
        List<Role> count=roleMapper.queryRole();
        PageHelper.startPage(receivePage.getPage(), receivePage.getRows());
        List<Role> list=roleMapper.queryRole();
        SendPage sendPage = new SendPage(count.size(),list);
        return sendPage;
    }



    @Override
    public void addPowerToRole(QueryParam queryParam) {
        //把之前的权限清理掉
        roleMapper.removePowerByRoleId(queryParam.getRoleId());

        roleMapper.addPowerToRole(queryParam.getRoleId(),queryParam.getPowerId());
    }

    @Override
    public void deletePermissionToRole(List<Integer> roid) {
        roleMapper.deletePermissionToRole(roid);
    }




}
