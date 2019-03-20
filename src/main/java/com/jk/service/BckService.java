package com.jk.service;

import com.jk.bean.*;

import java.util.List;

public interface BckService {
    void addEx(Example example);

    SendPage queryEx(ReceivePage receivePage);

    List<Exprent> quertAu();

    Example getEx(Integer id);

    void delEx(String ids);

    SendPage querySs(ReceivePage receivePage);

    void addSs(Sensitivity sensitivity);

    void delSs(Integer id);

    SendPage quertPingLun(ReceivePage receivePage);

    void updatePay(Integer id, Integer pay);
}
