package org.genesis.javacollector.springcloud.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: KG
 * @description:
 * @date: Created in 3:35 下午 2020/6/9
 * @modified by:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OAuthInMemoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(OAuthInMemoryApplication.class, args);
    }
}
