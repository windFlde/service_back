package com.jk.mapper;

import com.jk.bean.Exprent;
import com.jk.bean.WenZhang;
import com.jk.bean.ZG;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZGMapper {
    List<ZG> queryZG();

    ZG queryZGById(@Param("id") String id);

    void updateZG(ZG zg);

    void deleteZG(@Param("ids") String ids);

    void addZG(ZG zg);

    List<WenZhang> getAllTask();


    void updateTask(@Param("id") Integer id);

    List<Exprent> poiDerive(@Param("dis") String dis);
}
