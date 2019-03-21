package com.jk.controller;

import com.jk.bean.*;
import com.jk.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class RoleController {

    @Resource
    private RoleService roleService;

    @RequestMapping("queryRole")
    @ResponseBody
    public SendPage queryRole(Role role,ReceivePage receivePage) {

        SendPage sendPage=roleService.queryRole(role,receivePage);
        return sendPage;
    }





    //===给用户赋权限
    @ResponseBody
    @RequestMapping("addPowerToRole")
    public String addPowerToRole(QueryParam queryParam){
        roleService.deletePermissionToRole(queryParam.getRoleid());
        roleService.addPowerToRole(queryParam);

        return "";
    }

    //====给用户赋角色
    @RequestMapping("addRoleByUserId")
    @ResponseBody
    public String addRoleByUserId(QueryParam queryParam) {

        roleService.addRoleByUserId(queryParam);
        return "";
    }

    //=====移除角色
    @RequestMapping("removeRoleByUserId")
    @ResponseBody
    public  Result removeRoleByUserId(QueryParam queryParam) {
        Result result = new Result();
        try {
            roleService.removeRoleByUserId(queryParam);
            result.setState(true);
            result.setMsg("后台携带的数据");
        } catch (Exception e) {
            result.setState(false);
        }finally{


        }

        return result;

    }



}
