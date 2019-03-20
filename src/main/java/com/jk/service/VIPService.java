package com.jk.service;

import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.bean.VipInfo;

public interface VIPService {
    SendPage queryVIP(ReceivePage receivePage);

    void deleteVIP(String ids);

    void insertVIP(VipInfo vipInfo);
}
