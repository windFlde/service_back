package com.jk.utils;

import com.jk.bean.User;
import com.jk.bean.WenZhang;
import com.jk.service.ZGService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class Scheduler {

    @Autowired
    private JavaMailSenderImpl mailSender;

    protected static Logger logger = LoggerFactory.getLogger(Scheduler.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("  YY:MM:dd:HH:mm:ss");

    @Resource
    ZGService zgService;

    //每隔2秒执行一次
    @Scheduled(fixedRate = 1000)
    public void testTasks() {
        String format = dateFormat.format(new Date());
        //System.out.println("定时任务执行时间：" + format );

        //定时发布文章
        List<WenZhang> wen = zgService.getAllTask();

        for (WenZhang wenZhang : wen) {
            Date fabuTime = wenZhang.getFabuTime();
            String format1 = dateFormat.format(fabuTime);
            // System.out.println(format1);
            if (format.equals(format1)) {
                zgService.updateTask(wenZhang.getId());
                System.out.println(wenZhang.getName() + "发布成功");
            }

        }
        //定时发送到期提醒
        List<User> AllVipUser  = zgService.sendPhone();

        for (User user : AllVipUser) {
            if(user.getFasong() == 0){
                Date date = new Date(); //现在的时间
                long start = date.getTime();
                Date endtime = user.getEndtime();//到期时间
                long end = endtime.getTime();
                double asd = end - start;
                double day =  asd / 1000 / 60 / 60 / 24 ;
                //System.out.println(day);
                if(day==0 && user.getXufei() == 1){
                    if(user.getBalabce() >= 15){
                        //减余额
                        zgService.contmoney(user.getId());
                    }
                        long l = end + 86400000L;
                        Date date1 = new Date(l);
                        //增加VIP天数
                        zgService.addtime(user.getId(),date1);
                }
                if(day <= 2){
                    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
                    // 设置收件人，寄件人
                    simpleMailMessage.setTo(new String[]{user.getEmail()});
                    simpleMailMessage.setFrom("xzh120101@163.com");
                    simpleMailMessage.setSubject("【到期提醒】");
                    simpleMailMessage.setText("尊敬的"+user.getUsername()+"您好，您的VIP服务即将到期，为不影响您的使用请保证余额充足。");
                    // 发送邮件
                    mailSender.send(simpleMailMessage);
                    System.out.println("邮件已发送");
                    zgService.updateFS();
                }
            }
        }
    }
}
