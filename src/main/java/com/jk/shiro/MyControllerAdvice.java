package com.jk.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(value = AuthenticationException.class)
    public String errorHandler(Exception ex) {
        System.out.println("查询全局异常了");
        return "weishouquan";
    }

}
