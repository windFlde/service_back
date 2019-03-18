package com.jk.service;

import com.jk.bean.*;

import java.util.Date;
import java.util.List;

public interface ZGService {
    SendPage queryZG(ReceivePage receivePage);

    ZG queryZGById(String id);

    void updateZG(ZG zg);

    void deleteZG(String ids);

    void addZG(ZG zg);

    List<WenZhang> getAllTask();


    void updateTask(Integer id);

    List<Exprent> poiDerive(String dis);

    List<Exprent> getAllData();

    List<User> sendPhone();

    void updateFS();

    void contmoney(Integer id);

    void addtime(Integer id, Date date1);
}
