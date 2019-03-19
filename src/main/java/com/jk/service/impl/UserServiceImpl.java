package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.*;
import com.jk.mapper.UserMapper;
import com.jk.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public SendPage queryUser(ReceivePage receivePage) {



        List<User> count=userMapper.queryUser();
        PageHelper.startPage(receivePage.getPage(), receivePage.getRows());
        List<User> list=userMapper.queryUser();
        SendPage sendPage = new SendPage(count.size(), list);
        return sendPage;
    }

    @Override
    public void addUser(Users user) {
        userMapper.addUser(user);
    }

    @Override
    public void updateUser(Users user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(String[] ids) {
        userMapper.deleteUser(ids);
    }

    @Override
    public Users editUser(Integer id) {
        return userMapper.editUser(id);
    }


    @Override
    public ArrayList<Role> getAllRole() {
        return userMapper.getAllRole();
    }

    @Override
    public List<Integer> getRoleIdByUserId(String userId) {
        return userMapper.getRoleIdByUserId(userId);
    }


    @Override
    public List<Tree> queryTreeByRoleId(QueryParam queryParam) {
        List<Tree> list = userMapper.queryPermission("0");
        // 查询需要勾选tree的id
        List<Integer> permissionIds = userMapper.getPermissionIdByRoleId(queryParam.getRoleId());
        getTree(permissionIds, list);
        return list;
    }

    private void getTree(List<Integer> permissionIds, List<Tree> list) {

        for (Tree permission : list) {
            List<Tree> date = userMapper.queryPermission(permission.getId());
            getTree(permissionIds, date);
            // 如果一个节点是不勾选状态 则其祖先节点不能为勾选状态
            // if(permission.getId()==115||permission.getId()==107||permission.getId()==0)
            // permission.setChecked(false);
            permission.setChildren(date);

            // 什么该勾选
            if (permissionIds != null) {

                // exisChildren 有子节点是 true (!exisChildren)-->没有孩子
                boolean exisChildren = permission.getChildren() != null && permission.getChildren().size() > 0;

                // 如果当前节点有子节点就不能为勾选状态 如果子节点中有未勾选的节点 父节点如果选中择所有子节点全为勾选状态
                if (permissionIds.contains(permission.getId()) && !exisChildren) {//
                    // 如果当前遍历的树在 permissionIds集合中则当前树应该是勾选状态

                    // 如果当前遍历的树在 permissionIds集合中 并且当前节点没有子节点
                    permission.setChecked(true); // 就把其设置为勾选状态
                }

            }

        }
    }

}
