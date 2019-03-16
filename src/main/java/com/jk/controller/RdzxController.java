package com.jk.controller;

import com.jk.bean.Hotspot;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.service.RdzxService;
import com.jk.service.XxxService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RdzxController {

    @Resource
    private RdzxService rdzxService;

    @Resource
    XxxService xxxService;

    @RequestMapping("queryRdzx")
    public SendPage queryRdzx(Hotspot hotspot,ReceivePage receivePage) {

        SendPage sendPage=rdzxService.queryRdzx(hotspot,receivePage);
        return sendPage;


    }

    @RequestMapping("deleteHosport")
    public Boolean deleteHosport(String[] ids) {

        try {
            rdzxService.deleteHosport(ids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return  false;
        }
    }

  /* //上传图片
  @RequestMapping("upload")
    public String upload(MultipartFile img, HttpServletRequest request) {
      String fileUpload = FileUtil.FileUpload(img, request);
      return fileUpload;
  }*/


    @RequestMapping("addHotspot")
    public boolean addHotspot(Hotspot hotspot) {

        try {
            if (hotspot.getId() == null) {

                rdzxService.addHotspot(hotspot);

            }else{
                rdzxService.updateHotspot(hotspot);

            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    @RequestMapping("editHotspot")
    public Hotspot editHotspot(Hotspot hotspot) {

        Hotspot hotspot1=rdzxService.editHotspot(hotspot);
        return hotspot1;

    }
}
