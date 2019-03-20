package com.jk.controller;

import com.jk.bean.Tree;
import com.jk.bean.Users;
import com.jk.service.TreeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class TreeController {

    @Resource
    private TreeService treeService;
    
    @RequestMapping("queryTree")
    public List<Tree> queryTree() {/*HttpSession session*/

       /* Users user = (Users) session.getAttribute("user");*/
        return treeService.queryTree();/*user*/

    }





}
