//package com.gn.zuulproxy.filter;
//
//import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.repository.RateLimiterErrorHandler;
//import org.springframework.stereotype.Component;
//
///**
// * @program mystu
// * @description: redisLimiter
// * @author: gaoning
// * @create: 2019/11/05 16:53
// */
//@Component
//public class MyRateLimiterErrorHandler implements RateLimiterErrorHandler {
//    @Override
//    public void handleSaveError(String key, Exception e) {
//        System.out.println("save key Exception,key="+key+" , "+e.getStackTrace());
//    }
//
//    @Override
//    public void handleFetchError(String key, Exception e) {
//        System.out.println("Fetch key Exception,key="+key+" , "+e.getStackTrace());
//    }
//
//    @Override
//    public void handleError(String msg, Exception e) {
//        System.out.println("defalut key Exception,key="+msg+" , "+e.getStackTrace());
//    }
//}
