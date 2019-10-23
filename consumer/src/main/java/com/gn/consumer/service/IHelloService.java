package com.gn.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program mystu
 * @description:
 * @author: gaoning
 * @create: 2019/09/19 21:05
 */
@Component
@FeignClient(value = "hello-client")
public interface IHelloService {
    @GetMapping("/hello")
    public String hello();
}
