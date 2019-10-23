package com.gn.eurkserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurkserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurkserverApplication.class, args);
    }

}
