package com.jk.controller;

import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.bean.Title;
import com.jk.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("title")
public class TitleController {

    @Autowired
    TitleService titleService;

    /**
     * 查询总的标题
     */
    @ResponseBody
    @RequestMapping("queryTitle")
    public SendPage queryTitle(ReceivePage receivePage){
        return titleService.queryTitle(receivePage);
    }

    /**
     * 删除标题
     */
    @ResponseBody
    @RequestMapping("deleteTitle")
    public void deleteTitle(String ids){
        titleService.deleteTitle(ids);
    }

    /**
     * 新增标题
     */
    @ResponseBody
    @RequestMapping("insertTitle")
    public String insertTitle(Title title){
        String node = titleService.insertTitle(title);
        return node;
    }

    /**
     * 修改显示状态
     */
    @ResponseBody
    @RequestMapping("updateTitle")
    public void updateTitle(String id,Integer state){
        if(state == 0){
            state = 1;
        }else{
            state = 0;
        }
        titleService.updateTitle(id,state);
    }
}
