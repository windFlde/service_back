package com.jk.service.impl;

import com.jk.bean.Tree;
import com.jk.bean.Users;
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
    public List<Tree> queryTree() {/*Users user*/
        List<Tree> list = treeMapper.queryTree("0");
        treeNode(list);
        return list;
    }

    private void treeNode(List<Tree> list) {

        for (Tree tree : list) {
            List<Tree> date = treeMapper.queryTree(tree.getId());
            treeNode(date);
            tree.setChildren(date);
        }
    }


}
