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

    WenZhang querySites(WenZhang wenZhang);

    Integer getSites(@Param("sites") Integer sites);

    void updateSitesByIntSites(@Param("intSites") Integer intSites, @Param("id") Integer id);

    void updateBeforeSites(@Param("intSites") Integer intSites,@Param("sites") Integer sites);

    Integer getDownSite(@Param("sites") Integer sites);
}
