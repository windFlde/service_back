package com.jk.mapper;

import com.jk.bean.Tree;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface TreeMapper {


   /* List<Tree> queryTree(@Param("pid")String id,@Param("user")Users user);*/

    @Select("select * from t_tree where pid=#{value}")
    List<Tree> queryTree(String id);
}
