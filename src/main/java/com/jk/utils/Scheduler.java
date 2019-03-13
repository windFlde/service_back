package com.jk.utils;

import com.jk.bean.WenZhang;
import com.jk.service.ZGService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class Scheduler {

    protected static Logger logger = LoggerFactory.getLogger(Scheduler.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("  YY:MM:dd:HH:mm:ss");

    @Resource
    ZGService zgService;

    //每隔2秒执行一次
    @Scheduled(fixedRate = 1000)
    public void testTasks() {
        String format = dateFormat.format(new Date());
        //System.out.println("定时任务执行时间：" + format );
        List<WenZhang> wen = zgService.getAllTask();
        for (WenZhang wenZhang : wen) {
            Date fabuTime = wenZhang.getFabuTime();
            String format1 = dateFormat.format(fabuTime);
           // System.out.println(format1);
            if(format.equals(format1)){
                zgService.updateTask(wenZhang.getId());
                System.out.println(wenZhang.getName()+"发布成功");
            }
        }
    }

}
