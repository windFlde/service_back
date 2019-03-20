package com.jk.service;

import com.jk.bean.Advert;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;

public interface GgService {
    SendPage getData(ReceivePage receivePage);

    void addData(Advert advert);

    void deleteItemsById(Integer id);
}
