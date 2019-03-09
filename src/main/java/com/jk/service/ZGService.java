package com.jk.service;

import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.bean.ZG;

public interface ZGService {
    SendPage queryZG(ReceivePage receivePage);

    ZG queryZGById(String id);

    void updateZG(ZG zg);

    void deleteZG(String ids);

    void addZG(ZG zg);
}
