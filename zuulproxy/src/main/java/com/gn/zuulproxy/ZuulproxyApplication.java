package com.gn.zuulproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulproxyApplication {
//    @Value("${spring.redis.host}")
//    private String redisHost;
//
//    @Value("${spring.redis.port}")
//    private int redisPort;
//
//    @Value("${spring.redis.timeout}")
//    private int redisTimeout;
//
//    @Value("${spring.redis.password}")
//    private String redisAuth;
//
//    @Value("${spring.redis.database}")
//    private int redisDb;
//
//    @Value("${spring.redis.jedis.pool.max-active}")
//    private int maxActive;
//
//    @Value("${spring.redis.jedis.pool.max-wait}")
//    private int maxWait;
//
//    @Value("${spring.redis.jedis.pool.max-idle}")
//    private int maxIdle;
//
//    @Value("${spring.redis.jedis.pool.min-idle}")
//    private int minIdle;
//
//    @Bean
//    public RedisConnectionFactory connectionFactory() {
//        JedisPoolConfig poolConfig = new JedisPoolConfig();
//        poolConfig.setMaxTotal(maxActive);
//        poolConfig.setMaxIdle(maxIdle);
//        poolConfig.setMaxWaitMillis(maxWait);
//        poolConfig.setMinIdle(minIdle);
//        poolConfig.setTestOnBorrow(true);
//        poolConfig.setTestOnReturn(false);
//        poolConfig.setTestWhileIdle(true);
//        JedisClientConfiguration clientConfig = JedisClientConfiguration.builder()
//                .usePooling().poolConfig(poolConfig).and().readTimeout(Duration.ofMillis(redisTimeout)).build();
//
//        // 单点redis
//        RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();
//        // 哨兵redis
//        // RedisSentinelConfiguration redisConfig = new RedisSentinelConfiguration();
//        // 集群redis
//        // RedisClusterConfiguration redisConfig = new RedisClusterConfiguration();
//        redisConfig.setHostName(redisHost);
//        redisConfig.setPassword(RedisPassword.of(redisAuth));
//        redisConfig.setPort(redisPort);
//        redisConfig.setDatabase(redisDb);
//
//        return new JedisConnectionFactory(redisConfig,clientConfig);
//    }

    public static void main(String[] args) {
        SpringApplication.run(ZuulproxyApplication.class, args);
    }


}
