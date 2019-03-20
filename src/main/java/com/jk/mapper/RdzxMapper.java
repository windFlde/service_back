package com.jk.mapper;

import com.jk.bean.Hotspot;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RdzxMapper {

    List<Hotspot> queryRdzx(Hotspot hotspot);

    void deleteHosport(String[] ids);

    void updateHotspot(Hotspot hotspot);

    void addHotspot(Hotspot hotspot);

    Hotspot rdzxMapper(Hotspot hotspot);

    Hotspot querySites(Hotspot hotspot);

    Integer getSites(@Param("sites") Integer sites);

    void updateBeforeSites(@Param("intSites") Integer intSites, @Param("sites") Integer sites);

    void updateSitesByIntSites(@Param("intSites") Integer intSites, @Param("id") Integer id);

    Integer getDownSite(@Param("sites") Integer sites);
}
