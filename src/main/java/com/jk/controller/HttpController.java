package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.utils.HttpClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("http")
public class HttpController {

    @ResponseBody
    @RequestMapping("queryLngAndLat")
    public HashMap<String, String> queryLngAndLat() {
        // 调用别人的接口
        Map<String, Object> params = new HashMap<>();
        params.put("ip","");
        params.put("coor","bd09ll");
        params.put("ak","QgIL94NnAW7QKTceQjTOT7cm9zXcAezU");
        String result = HttpClient.sendGet("http://api.map.baidu.com/location/ip",params);
        HashMap<String, String> map = new HashMap<>();

        JSONObject parseObject = JSONObject.parseObject(result);
        String resultStatus = parseObject.getString("status");
        if (!resultStatus.equals("0")) {
            map.put("statusNo","statusNo");
            return map;
        }
        //获取content
        JSONObject resultContent = JSONObject.parseObject(result);
        String rcontent = resultContent.getString("content");

        //获取content 里面的  point
        JSONObject resultRcontent=JSONObject.parseObject(rcontent);
        String resultPoint=resultRcontent.getString("point");
        //获取point下面的  x   经度  y  纬度
        //获取x   经度
        JSONObject resultX=JSONObject.parseObject(resultPoint);
        String x = resultX.getString("x");
        //获取y   纬度
        JSONObject resultY = JSONObject.parseObject(resultPoint);
        String y = resultY.getString("y");
        map.put("x",x);
        map.put("y",y);
        return map;
    }
    @ResponseBody
    @RequestMapping("makeUserSite")
    public HashMap<String, String>makeUserSite(String x,String y) {
        // 调用别人的接口
        Map<String, Object> params = new HashMap<>();
        params.put("lng",x);
        params.put("lat",y);
        params.put("key","0103f1ebd3e80156b998beba5ee258d1");
        params.put("type","5");
        String sendPost = HttpClient.sendGet("http://apis.juhe.cn/geo/", params);
        System.out.println("sendPost====================="+sendPost);

        JSONObject resultResult = JSONObject.parseObject(sendPost);
        String str=resultResult.getString("result");

        JSONObject strResult = JSONObject.parseObject(str);
        String extResult = strResult.getString("ext");

        //获取ext 下面的 省 市
        JSONObject ext = JSONObject.parseObject(extResult);
        String province = ext.getString("province");
        String city = ext.getString("city");
        String district = ext.getString("district");

        HashMap<String, String> map = new HashMap<>();
        map.put("province",province);
        map.put("city",city);
        map.put("district",district);
        return map;
    }

}
