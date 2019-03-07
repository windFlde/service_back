package com.jk.service;

import com.jk.bean.Example;
import com.jk.bean.Exprent;
import com.jk.bean.ReceivePage;
import com.jk.bean.ZG;

import java.util.List;

public interface BckService {
    void addEx(Example example);

    List<Example> queryEx(ReceivePage receivePage);

    List<Exprent> quertAu();


}
