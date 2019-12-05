//package com.gn.zuulproxy.filter;
//
//import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.Rate;
//import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.properties.RateLimitProperties;
//import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.repository.RedisRateLimiter;
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import com.netflix.zuul.exception.ZuulException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.util.ReflectionUtils;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.logging.Logger;
//
///**
// * @program mystu
// * @description:
// * @author: gaoning
// * @create: 2019/11/06 16:53
// */
//@Component
//public class MyRedisFilter extends ZuulFilter {
//    private static Logger log = Logger.getLogger(MyRedisFilter.class.toString());
//    @Autowired
//    private RedisTemplate redisTemplate;
//    @Autowired
//    private RateLimitProperties rateLimitProperties;
//    @Autowired
//    private MyRateLimiterErrorHandler myRateLimiterErrorHandler;
//
//    private static RedisRateLimiter rdsLimiter ;
//    {
//        rdsLimiter = new RedisRateLimiter(myRateLimiterErrorHandler,redisTemplate);
//    }
//
//    @Override
//    public String filterType() {
//        return "pre";
//    }
//
//    @Override
//    public int filterOrder() {
//        return 1;
//    }
//
//    @Override
//    public boolean shouldFilter() {
//        return true;
//    }
//
//    @Override
//    public Object run() throws ZuulException {
//        try {
//            RequestContext ctx = RequestContext.getCurrentContext();
//            HttpServletRequest request = ctx.getRequest();
//            log.info("coming = "+request.getRequestURI());
//            HttpServletResponse response = ctx.getResponse();
//            System.out.println(rateLimitProperties.toString());
//            //自定义限流策略
////            RateLimitProperties.Policy policy = new RateLimitProperties.Policy();
////            policy.setLimit(5L);
////            policy.setQuota(10L);
////            policy.setRefreshInterval(60L);
//            //从配置信息中获取限流策略
//            RateLimitProperties.Policy policy = rateLimitProperties.getPolicies().get("hello-consumer");
//
//            Rate rate = rdsLimiter.consume(policy,"myLimit:hello-consumer:0:0:0:0:0:0:0:1",1L);
//            if(rate.getRemaining()<0){
//                ctx.setSendZuulResponse(false);
//                response.setStatus(200);
//                response.getWriter().write("{\"code\": 99999,\"message\": \"redis limit too many requests.\"}");
//            }
//        } catch (Exception e) {
//            log.warning(e.getMessage());
//            ReflectionUtils.rethrowRuntimeException(e);
//        }
//        return null;
//    }
//}
