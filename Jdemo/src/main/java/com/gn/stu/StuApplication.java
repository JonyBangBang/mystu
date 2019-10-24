package com.gn.stu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.gn")
public class StuApplication {

    public static void main(String[] args) {
        SpringApplication.run(StuApplication.class, args);
//        Object obj=  MyApplicationContext.getbean("bird");
//        System.out.println(obj.toString());
    }
    // 注解支持的配置Bean
}
