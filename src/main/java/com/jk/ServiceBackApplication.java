package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.jk.mapper")
@EnableScheduling
public class ServiceBackApplication {


    public static void main(String[] args) {
        SpringApplication.run(ServiceBackApplication.class, args);
    }

}
