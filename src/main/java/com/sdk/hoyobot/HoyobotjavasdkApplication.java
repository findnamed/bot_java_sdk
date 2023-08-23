package com.sdk.hoyobot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;
//有数据库使用此
//@SpringBootApplication
//无数据库使用此
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//
public class HoyobotjavasdkApplication {

    public static void main(String[] args) {
        SpringApplication.run(HoyobotjavasdkApplication.class, args);
    }

}
