package org.genesis.javacollector.springboot.kafka;

import org.genesis.javacollector.springboot.kafka.producer.UserLogProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * @author: KG
 * @description:
 * @date: Created in 10:21 AM 2019/7/29
 * @modified by:
 */
@SpringBootApplication
public class GsSbtKafkaApplication {
    @Autowired
    private UserLogProducer kafkaSender;

    @PostConstruct
    public void init() {
        for (int i = 0; i < 10; i++) {
            //调用消息发送类中的消息发送方法
            kafkaSender.sendLog(String.valueOf(i));
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(GsSbtKafkaApplication.class, args);
    }
}
