package com.jk.controller;

import com.jk.service.XxxService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@Controller
public class HomeController {

    @Resource
    XxxService xxxService;

    @RequestMapping("toView")
    public String toView(String viewName, HttpSession session) {
        return viewName;
    }
}
