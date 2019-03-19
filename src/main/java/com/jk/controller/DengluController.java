package com.jk.controller;

import com.jk.bean.Users;
import com.jk.service.DengluService;
import com.jk.utils.CheckImgUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@RestController
public class DengluController {

    @Resource
    private DengluService dengluService;

    @RequestMapping("login")
    public HashMap<String, String> login(Users user, String checkCode, HttpServletRequest request) {

        HashMap<String, String> param = new HashMap<>();

        HttpSession session = request.getSession();

        //session中的验证码
        String OneCode = (String) session.getAttribute("checkcode");
        if (!checkCode.equals(OneCode)) {

            param.put("code","1");
            param.put("msg", "验证码错误");
            return param;

        }

        //查询账号如果找不到表示账号不存在
       Users users=dengluService.login(user);
        if (users == null) {

            param.put("code", "0");
            param.put("msg", "密码错误");
            return param;
        }
        //判断密码是正确
        String s =users.getUserpswd();
        if (!s.equals(user.getUserpswd())) {

            param.put("code", "2");
            param.put("msg", "密码错误");
            return param;
        }

        session.setAttribute(session.getId(),users);
        param.put("code", "3");
        param.put("msg", "登陆成功");
        return param;


    }

    /**
     * 获取验证码
     * @throws IOException
     */
    @RequestMapping("getCodeName")
    private void getCodeName(HttpServletRequest request, HttpServletResponse response) throws IOException {

        CheckImgUtil.checkImg(request, response);
    }

    /**
     * 注册
     */
    @RequestMapping("addCode")
    public Boolean addCode(Users users) {

        try {
            users.setVip(0);
            users.setBalance(0);
            dengluService.addCode(users);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return  false;
        }
    }
}
