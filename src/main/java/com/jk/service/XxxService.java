package com.jk.service;

import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.bean.WenZhang;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface XxxService {

    SendPage queryWenZhang(WenZhang w, ReceivePage receivePage);

    void insertWenZhang(WenZhang wenZhang);

    void deleteWenZhang(String ids);

}
