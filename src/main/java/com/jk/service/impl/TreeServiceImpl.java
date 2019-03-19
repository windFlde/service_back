package com.jk.service.impl;

import com.jk.bean.Tree;
import com.jk.mapper.TreeMapper;
import com.jk.service.TreeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class TreeServiceImpl implements TreeService {

    @Resource
    private TreeMapper treeMapper;


    @Override
    public List<Tree> queryTree() {
        String id="0";
        List<Tree> treeNode=treeNode(id);
        return treeNode;
    }

    @Override
    public void removeItem(Integer id) {

        ArrayList<String> ids = new ArrayList<>();
        ids.add("id");
        // 6 7
        List<String> childernId = treeMapper.getTreeIdByPid("id");

        getChildernId(ids, childernId);

        System.out.println(ids);

        treeMapper.removeItem(ids);
    }

    @Override
    public void addTreeItemToTreeId(Tree tree) {
        treeMapper.addTreeItemToTreeId(tree);
    }

    /*@Override
    public List<Tree> queryPermission() {
        List<Tree> list = treeMapper.queryPermission(0);
        getTree(null,list);
        return list;
    }*/


    /*private void getTree(Object o, List<Tree> list) {


    }*/


    private void getChildernId(ArrayList<String> ids, List<String> childernId) {

        for (String cid : childernId) {

            // 112 113
            List<String> temp = treeMapper.getTreeIdByPid(cid);

            getChildernId(ids, temp);

            ids.add(cid);
        }
    }

    private List<Tree> treeNode(String id) {
        List<Tree> trees=treeMapper.queryTree(id);
        for (Tree tree : trees) {
            List<Tree> treeNode=treeNode(tree.getId());
            tree.setChildren(treeNode);

        }
        return trees;
    }
}
