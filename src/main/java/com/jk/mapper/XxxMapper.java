package com.jk.mapper;

import com.jk.bean.WenXian;
import com.jk.bean.WenZhang;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XxxMapper {


    void insertWenZhang(WenZhang wenZhang);

    void deleteWenZhang(@Param("ids") String ids);

    void updateWenZhang(WenZhang wenZhang);

    List<WenZhang> queryWenZhang(WenZhang w);

    List<WenXian> queryWenXian();

    void deleteWenXian(@Param("ids") String ids);

    void insertWenXian(WenXian wenZhang);
}
