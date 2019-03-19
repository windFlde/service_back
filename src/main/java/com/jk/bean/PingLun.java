package com.jk.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "t_pinglun")
@AllArgsConstructor
@NoArgsConstructor
public class PingLun {

    String _id;
    String content;
    String name="匿名用户";
    Integer em_id;
    Integer userId;
    String img="https://mmb-toutiao.oss-cn-shanghai.aliyuncs.com/toutiaoImage/ee8d0b7e9e8e5a9f390f6be8856b868b.jpeg?x-oss-process=image/resize,w_440";
    String time;
    String huifu="";
    String aa = "";
    Integer black;
}
