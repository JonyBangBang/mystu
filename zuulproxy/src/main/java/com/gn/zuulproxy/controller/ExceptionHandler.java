package com.gn.zuulproxy.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program mystu
 * @description: 限流异常处理类
 * @author: gaoning
 * @create: 2019/11/03 14:36
 */
@RestController
public class ExceptionHandler implements ErrorController {

    @Override
    public String getErrorPath() {

        return "error";
    }

    @RequestMapping(value="/error")
    public String error(){
        return "{\"result\":\"访问太多频繁，请稍后再访问！！！\"}";
    }

}
