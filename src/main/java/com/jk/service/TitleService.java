package com.jk.service;

import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.bean.Title;

public interface TitleService {
    SendPage queryTitle(ReceivePage receivePage);

    void deleteTitle(String ids);

    String insertTitle(Title title);

    void updateTitle(String id,Integer state);
}
