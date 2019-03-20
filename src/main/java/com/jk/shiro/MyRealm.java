package com.jk.shiro;


import com.jk.bean.Role;
import com.jk.bean.TreeTwo;
import com.jk.bean.User;
import com.jk.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 业精于勤荒于嬉,行成于思毁于随
 *
 * @Date 2019/2/28 13:49
 * @Created by wuzhuang
 * <p>
 * 进行认证和授权
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String loginacct = SecurityUtils.getSubject().getPrincipal().toString();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        List<Role> roleUser = userService.getUserRole(loginacct);
        for (Role role : roleUser) {
            authorizationInfo.addRole(role.getShiroRoleName());
            List<TreeTwo> per = userService.getUserPer(role.getId());
            for (TreeTwo permission : per) {
                authorizationInfo.addStringPermission(permission.getShiroPerName());
            }
        }

        return authorizationInfo;
    }

    /**
     * 认证的代码放到此方法中
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        // UsernamePasswordToken token1 = (UsernamePasswordToken) token;
        //String username1 = token1.getUsername();

        //当前登录的用户名
        String username = token.getPrincipal().toString();

        //假装根据用户名去查找数据库信息  select password from user where username = #{username}

        //String password = "123123";//从数据库查询出来的密码
        String password = userService.getPassword(username);

        if (password == null ) {
                return null;
        }

        //wo ->  guster  ps:123456    实参 -> guster  abcpassword123
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password, this.getName());
        //SimpleAuthenticationInfo 构造方法中只需放入正确的用户名和密码即可

        return simpleAuthenticationInfo;//如果此处返回null 会报UnknownAccountException 没有此账号的异常
        //如果用户名和密码不匹配会抛出 IncorrectCredentialsException异常
    }
}
