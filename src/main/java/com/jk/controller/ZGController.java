package com.jk.controller;

import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.bean.ZG;
import com.jk.service.ZGService;
import com.jk.utils.OssUpFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Controller
@RequestMapping("zhuanjia")
public class ZGController {

    @Autowired
    ZGService zgService;

    /**
     * 查询
     */
    @ResponseBody
    @RequestMapping("queryZG")
    public SendPage queryZG(ReceivePage receivePage){
        return zgService.queryZG(receivePage);
    }

    /**
     * 回显
     */
    @ResponseBody
    @RequestMapping("queryZGById")
    public ZG queryZGById(String id){
        return zgService.queryZGById(id);
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("updateZG")
    public void updateZG(ZG zg){
        zgService.updateZG(zg);
    }

    /**
     * 删除(批量删)
     */
    @ResponseBody
    @RequestMapping("deleteZG")
    public void deleteZG(String ids){
        zgService.deleteZG(ids);
    }

    /**
     * 新增
     */
    @ResponseBody
    @RequestMapping("addZG")
    public void addZG(ZG zg){
        if(zg.getDt_qw()==null){
            zg.setDt_qw(0);
        }
        zgService.addZG(zg);
    }

    /**
     * 跳页面
     */
    @RequestMapping("toView")
    public String toView(String viewname){
        return viewname;
    }

    /**
     * 上传文件
     */
    String filename = "";
    @ResponseBody
    @PostMapping("toUploadBlog")
    public String toUploadBlog(@RequestParam("file") MultipartFile file){
        Map<String, Object> stringObjectMap = OssUpFileUtil.uploadFile(file);
        System.out.println(stringObjectMap);
        String count = "";
        for (String key : stringObjectMap.keySet()) {
            Object o = stringObjectMap.get(key);
            System.out.println("key: " + key + " value: " + o);
            if(key=="url"){
                count+=o;
                filename = count;
            } }
        return count;
    }
}
