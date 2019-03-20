package com.jk.controller;

import com.jk.bean.Hotspot;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.bean.WenZhang;
import com.jk.service.RdzxService;
import com.jk.service.XxxService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    //上移
    @RequestMapping("upSites")
    public String upSites(Hotspot hotspot) {
        Hotspot hotspot2=rdzxService.querySites(hotspot);
        Integer intSites=rdzxService.getSites(hotspot2.getSites());
        if (intSites==null) {
            return "intSitesFail";
        }else{
            rdzxService.updateSitesByIntSites(intSites,hotspot2.getId(),hotspot2.getSites());
            return "intSitesOk";
        }
    }

    //下移
    @RequestMapping("downSites")
    public String downSites(Hotspot hotspot) {
        Hotspot hotspot2=rdzxService.querySites(hotspot);
        Integer downSites=rdzxService.getDownSite(hotspot2.getSites());
        if (downSites==null) {
            return "downSitesFail";
        }else{
            rdzxService.updateSitesByIntSites(downSites,hotspot2.getId(),hotspot2.getSites());
            return "downSitesOk";
        }
    }
}
