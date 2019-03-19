package com.jk.controller;

import com.jk.bean.*;
import com.jk.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class UserController {


    @Resource
    UserService userService;



    @RequestMapping("queryUser")
    @ResponseBody
    public SendPage queryUser(ReceivePage receivePage) {

        SendPage sendPage = userService.queryUser(receivePage);
        return sendPage;

    }

    @RequestMapping("addUser")
    @ResponseBody
    public Boolean addUser(Users user) {

        try {
            if (user.getId() == null) {

                userService.addUser(user);
            }else{

                userService.updateUser(user);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("deleteUser")
    @ResponseBody
    public Boolean deleteUser(String[] ids) {

        try {
            userService.deleteUser(ids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("editUser")
    @ResponseBody
    public Users editUser(Integer id) {

        Users user=userService.editUser(id);
        return user;
    }


   @RequestMapping("assignrole")
    public String assignRole(String id,Model model) {

       model.addAttribute("msg",id);

        ArrayList<Role> assignRole = new ArrayList<>();

        ArrayList<Role> unassignRole = new ArrayList<>();

        // 先查询出数据库所有的角色
        ArrayList<Role>  allRole=userService.getAllRole();
        // {id:1,name:xxx},{id:2,name:xxx},{id:3,name:xxx},{id:4,name:xxx}

        // 查询当前用户拥有角色id 2,4
        List<Integer> roleIds=userService.getRoleIdByUserId(id);

        for (Role role : allRole) {

            if(roleIds.contains(role.getId())){
                assignRole.add(role);
            }else {

                unassignRole.add(role);
            }
        }

        model.addAttribute("assignRole", assignRole);
        model.addAttribute("unassignRole", unassignRole);
        return "assignRole";

    }

    @RequestMapping("toPower")
    public String toPower(String id, Model model){
        model.addAttribute("msg",id);
        return "assignpower";
    }

    //====根据角色查询权限
    @RequestMapping("queryTreeByRoleId")
    @ResponseBody
    public List<Tree> queryTreeByRoleId(QueryParam queryParam) {
        List<Tree> list=userService.queryTreeByRoleId(queryParam);
        return list;
    }


}
