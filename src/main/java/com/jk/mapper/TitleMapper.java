package com.jk.mapper;

import com.jk.bean.Title;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TitleMapper {
    List<Title> queryTitle();

    void deleteTitle(@Param("ids") String ids);

    void insertTitle(Title title);

    void updateTitle(@Param("id") String id,@Param("state") Integer state);

    Integer getcot(@Param("block") Integer block);
}
