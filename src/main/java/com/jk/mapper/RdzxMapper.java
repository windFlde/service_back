package com.jk.mapper;

import com.jk.bean.Hotspot;

import java.util.List;

public interface RdzxMapper {

    List<Hotspot> queryRdzx(Hotspot hotspot);

    void deleteHosport(String[] ids);

    void updateHotspot(Hotspot hotspot);

    void addHotspot(Hotspot hotspot);

    Hotspot rdzxMapper(Hotspot hotspot);
}
