package com.sdyin.mall.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableFeignClients
public class MallUserApplication {

    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(MallUserApplication.class, args);
        String userAge = applicationContext.getEnvironment().getProperty("user.age");
        System.out.println("----config -> userAge------" + userAge);
    }

}
