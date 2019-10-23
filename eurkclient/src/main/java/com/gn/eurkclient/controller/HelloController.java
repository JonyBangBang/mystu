package com.gn.eurkclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @program mystu
 * @description: hello
 * @author: gaoning
 * @create: 2019/09/17 15:56
 */
@RestController
public class HelloController {
    @Autowired
    private HttpServletRequest httpServletRequest;


    @GetMapping(value = "/hello")
    public String hello() {
        return "hello##ip:" + httpServletRequest.getLocalAddr() + ",port:" + httpServletRequest.getLocalPort()
                + "\ntime:" + System.currentTimeMillis();
    }

    @GetMapping(value = "/world")
    public String world() {
        return "world##ip:" + httpServletRequest.getLocalAddr() + ",port:" + httpServletRequest.getLocalPort()
                + "\ntime:" + System.currentTimeMillis();
    }
}
