package com.jk.mapper;

import com.jk.bean.User;
import com.jk.bean.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DengluMapper {

    @Select("select loginacct,userpswd,username from t_user where loginacct=#{loginacct}")
    Users login(Users user);

    @Insert("insert into t_user(username,loginacct,userpswd) values(#{username},#{loginacct},#{userpswd})")
    void addCode(Users users);

    /*List<String> getAccessableUrlByUserId(Integer id);*/
}
