package com.gn.streamkafka.kfkapi;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @program mystu
 * @description: kafka API
 * @author: gaoning
 * @create: 2019/09/23 15:04
 */
@RestController
public class producer {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(producer.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping(value="/send")
    public void sendMessage(@RequestParam String topic, @RequestParam Object object) {

        /*
         * 这里的ListenableFuture类是spring对java原生Future的扩展增强,是一个泛型接口,用于监听异步方法的回调
         * 而对于kafka send 方法返回值而言，这里的泛型所代表的实际类型就是 SendResult<K, V>,而这里K,V的泛型实际上
         * 被用于ProducerRecord<K, V> producerRecord,即生产者发送消息的key,value 类型
         */
        Map map = new HashMap<String,String>();
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, object);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                logger.info("发送消息失败:" + throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> sendResult) {
                System.out.println("发送结果:" + sendResult.toString());
            }
        });
    }

    /**
     * 测试Properties kafka
     * @return
     */
    public boolean sendProp(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.0.137:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 10);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        Future future =  producer.send(new ProducerRecord<String, String>("sunday", "hello"));
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return true;
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
