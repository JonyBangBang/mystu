package com.gn.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program mystu
 * @description:
 * @author: gaoning
 * @create: 2019/09/19 21:05
 */
@FeignClient(value = "hello-service")
public interface IHelloService {
    @GetMapping("/hello")
    public String hello();
}
