package com.gn.consumer.controller;

import com.gn.consumer.service.IHelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @program mystu
 * @description:
 * @author: gaoning
 * @create: 2019/09/19 20:51
 */
@RestController
//@DefaultProperties(defaultFallback = "defaultFail")
public class HelloController {

    @Autowired
    private IHelloService iHelloService;

    private Random r = new Random();
        @HystrixCommand(commandProperties =
                {
                        // 熔断器在整个统计时间内是否开启的阀值
                        @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
                        // 至少有3个请求才进行熔断错误比率计算
                        /**
                         * 设置在一个滚动窗口中，打开断路器的最少请求数。
                         比如：如果值是20，在一个窗口内（比如10秒），收到19个请求，即使这19个请求都失败了，断路器也不会打开。
                         */
                        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3"),
                        //当出错率超过50%后熔断器启动
                        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                        // 熔断器工作时间，超过这个时间，先放一个请求进去，成功的话就关闭熔断，失败就再等一段时间
                        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
                        // 统计滚动的时间窗口
                        @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000")
                })
        @GetMapping("/consumer/hystrix")
        public String test1() {
            int id = r.nextInt(20);
            System.out.println("id:" + id);
            String s = iHelloService.hello();
//            if (id % 2 == 0) {
//                throw new RuntimeException();
//            }
            return "hystrix_" + id+","+s;
        }

        private String defaultFail() {
            System.out.println("default fail");
            return "default fail";
        }

        @GetMapping("/limit/hello")
        public String helloRateLimit(){
            String s = iHelloService.hello();
            return "rateLimit:"+s;
        }

    @GetMapping("/hello")
    public String hellot(){
//        String s = iHelloService.hello();
        return "hello！";
    }

}
