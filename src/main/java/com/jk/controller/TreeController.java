package com.jk.controller;

import com.jk.bean.Tree;
import com.jk.service.TreeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TreeController {

    @Resource
    private TreeService treeService;
    
    @RequestMapping("queryTree")
    public List<Tree> queryTree() {


        return treeService.queryTree();
        
    }

    @RequestMapping("removeItem")
    public String removeItem(Integer id) {

        treeService.removeItem(id);
        return "";
    }

    @RequestMapping("addTreeItemToTreeId")
    public String addTreeItemToTreeId(Tree tree){
        treeService.addTreeItemToTreeId(tree);
        return "1";
    }

  /*  @RequestMapping("queryTree")
    public List<Tree> queryPermission(){
        List<Tree> list = treeService.queryPermission();
        return list;
    }*/



}
