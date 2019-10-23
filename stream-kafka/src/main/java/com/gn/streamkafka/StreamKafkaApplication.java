package com.gn.streamkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
@Configuration
public class StreamKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamKafkaApplication.class, args);
    }

}
