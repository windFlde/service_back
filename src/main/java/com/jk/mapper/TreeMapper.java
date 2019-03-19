package com.jk.mapper;

import com.jk.bean.Tree;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;

public interface TreeMapper {

    @Select("select * from t_tree where pid = #{value}")
    List<Tree> queryTree(String id);

    void removeItem(@Param("ids") ArrayList<String> ids);

    @Select("select id from t_tree where pid = #{id}")
    List<String> getTreeIdByPid(String id);

    void addTreeItemToTreeId(Tree tree);
}
