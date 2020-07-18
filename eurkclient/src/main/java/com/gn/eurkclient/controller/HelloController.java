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

    private long seq = -1L;

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

    @GetMapping(value = "/helloCat")
    public String catTest(String args){
        String resString = null;
//        Transaction t = Cat.newTransaction("URL", "pageName");
//        try {
//            Cat.logEvent("URL.Server", "serverIp", Event.SUCCESS, "ip=${serverIp}");
//            Cat.logMetricForCount("metric.key");
//            Cat.logMetricForDuration("metric.key", 5);
//
//            resString = "hello cat "+args;
//
//            t.setStatus(Transaction.SUCCESS);
//        } catch (Exception e) {
//            t.setStatus(e);
//            Cat.logError(e);
//        } finally {
//            t.complete();
//        }
        resString = "hello cat "+args;
        return resString;
    }

}
