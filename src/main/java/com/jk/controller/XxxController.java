package com.jk.controller;

import com.jk.bean.*;
import com.jk.service.XxxService;
import com.jk.utils.OssUpFileUtil;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("xjw")
public class XxxController {

    @Resource
    private XxxService xxxService;

    @Resource
    private MongoTemplate mongoTemplate;

    @RequestMapping("toView")
    public String toView(String v) {
        return v;
    }

    @ResponseBody
    @RequestMapping("queryWenZhang")
    public SendPage queryWenZhang(WenZhang w, ReceivePage receivePage) {
        SendPage list =xxxService.queryWenZhang(w,receivePage);
        return list;
    }
    @ResponseBody
    @RequestMapping("queryWenXian")
    public SendPage queryWenXian(ReceivePage receivePage) {
        SendPage list =xxxService.queryWenXian(receivePage);
        return list;
    }
    @ResponseBody
    @RequestMapping("insertWenZhang")
    public String insertWenZhang(WenZhang wenZhang) {
        xxxService.insertWenZhang(wenZhang);
        return "";
    }
    @ResponseBody
    @RequestMapping("insertWenXian")
    public String insertWenXian(WenXian wenZhang) {
        xxxService.insertWenXian(wenZhang);
        return "";
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

    @ResponseBody
    @RequestMapping("deleteWenZhang")
    public void deleteWenZhang(String  ids) {
        xxxService.deleteWenZhang(ids);
    }
    @ResponseBody
    @RequestMapping("deleteWenXian")
    public void deleteWenXian(String  ids) {
        xxxService.deleteWenXian(ids);
    }
    @ResponseBody
    @RequestMapping("getLog")
    public SendPage getLog(ReceivePage receivePage) {
        SendPage sendPage=xxxService.getLog(receivePage);
        return sendPage;
    }

}
