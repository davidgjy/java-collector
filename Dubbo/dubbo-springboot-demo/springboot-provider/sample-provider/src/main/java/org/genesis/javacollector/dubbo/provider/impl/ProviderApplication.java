package org.genesis.javacollector.dubbo.provider.impl;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: KG
 * @description:
 * @date: Created in 10:14 上午 2020/5/26
 * @modified by:
 */
@DubboComponentScan
@SpringBootApplication
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}
