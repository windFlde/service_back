package com.jk.service;

import com.jk.bean.Hotspot;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;

public interface RdzxService {
    SendPage queryRdzx(Hotspot hotspot, ReceivePage receivePage);

    void deleteHosport(String[] ids);

    void addHotspot(Hotspot hotspot);

    void updateHotspot(Hotspot hotspot);

    Hotspot editHotspot(Hotspot hotspot);

    Hotspot querySites(Hotspot hotspot);

    Integer getSites(Integer sites);

    void updateSitesByIntSites(Integer intSites, Integer id, Integer sites);

    Integer getDownSite(Integer sites);
}
