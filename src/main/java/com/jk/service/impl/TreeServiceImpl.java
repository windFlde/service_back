package com.jk.service.impl;

import com.jk.bean.Tree;
import com.jk.mapper.TreeMapper;
import com.jk.service.TreeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    private List<Tree> treeNode(String id) {
        List<Tree> trees=treeMapper.queryTree(id);
        for (Tree tree : trees) {
            List<Tree> treeNode=treeNode(tree.getId());
            tree.setChildren(treeNode);

        }
        return trees;
    }
}
