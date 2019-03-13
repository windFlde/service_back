package com.jk.bean;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "t_loginLog")
public class LoginLog {
    private String id;
    private String userName;
    private String logName;
    private Date createTime;

    public LoginLog(String userName, String logName, Date createTime) {
        this.userName = userName;
        this.logName = logName;
        this.createTime = createTime;
    }
}
