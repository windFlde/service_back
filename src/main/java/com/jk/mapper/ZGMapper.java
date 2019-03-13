package com.jk.mapper;

import com.jk.bean.ZG;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZGMapper {
    List<ZG> queryZG();

    ZG queryZGById(@Param("id") String id);

    void updateZG(ZG zg);

    void deleteZG(@Param("ids") String ids);

    void addZG(ZG zg);
}
