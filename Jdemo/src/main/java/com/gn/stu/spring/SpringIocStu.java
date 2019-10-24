package com.gn.stu.spring;

import com.gn.stu.pojo.Bird;
import com.gn.stu.pojo.Fish;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @program stu
 * @description: spring IOC 原理学习
 * @author: gaoning
 * @create: 2019/08/06 11:29
 */
@Component
public class SpringIocStu  {

    @Bean(name="bird")
    public Object getBird(){
        System.out.println("bird...");
        return new Bird();
    }

    @Bean(name="fish")
    public Object getFish(){
        System.out.println("fish...");
        return new Fish();
    }
}
