package org.genesis.javacollector.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: KG
 * @description:
 * @date: Created in 3:07 下午 2020/6/9
 * @modified by:
 */
@SpringBootApplication
@EnableEurekaServer
public class DiscoverApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiscoverApplication.class, args);
    }
}
