package com.jk.service;

import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.bean.WenZhang;

public interface XxxService {

    SendPage queryWenZhang(WenZhang w, ReceivePage receivePage);

    void insertWenZhang(WenZhang wenZhang);

    void deleteWenZhang(String ids);
}
