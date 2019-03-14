package com.jk.service;

import com.jk.bean.Example;
import com.jk.bean.Exprent;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;

import java.util.List;

public interface BckService {
    void addEx(Example example);

    SendPage queryEx(ReceivePage receivePage);

    List<Exprent> quertAu();

    Example getEx(Integer id);

    void delEx(String ids);


}
