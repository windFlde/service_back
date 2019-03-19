package com.jk.service;

import com.jk.bean.Tree;

import java.util.List;

public interface TreeService {

    List<Tree> queryTree();

    void removeItem(Integer id);

    void addTreeItemToTreeId(Tree tree);

    /*List<Tree> queryPermission();*/
}
