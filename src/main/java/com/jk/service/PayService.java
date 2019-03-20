package com.jk.service;

import com.jk.bean.Pay;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;

public interface PayService {
    SendPage getData(ReceivePage receivePage);

    Pay updateItem(Integer id);

    void addData(Pay pay);
}
