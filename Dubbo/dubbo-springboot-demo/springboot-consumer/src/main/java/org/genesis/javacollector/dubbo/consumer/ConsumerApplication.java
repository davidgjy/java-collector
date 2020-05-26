package org.genesis.javacollector.dubbo.consumer;

import org.apache.dubbo.config.annotation.Reference;
import org.genesis.javacollector.dubbo.provider.api.HelloService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author: KG
 * @description:
 * @date: Created in 10:21 上午 2020/5/26
 * @modified by:
 */
@SpringBootApplication
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
