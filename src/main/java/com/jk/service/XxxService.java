package com.jk.service;

import com.jk.bean.*;

public interface XxxService {

    SendPage queryWenZhang(WenZhang w, ReceivePage receivePage);

    void insertWenZhang(WenZhang wenZhang);

    void deleteWenZhang(String ids);

    SendPage queryWenXian(ReceivePage receivePage);

    void insertWenXian(WenXian wenZhang);

    void deleteWenXian(String ids);

    SendPage getLog(ReceivePage receivePage);
}
