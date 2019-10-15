package com.genesis.javacollector.springboot.starter.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: KG
 * @description:
 * @date: Created in 11:07 AM 2019/10/15
 * @modified by:
 */
@Data
@ConfigurationProperties(prefix = "com.genesis.service")
public class ServiceConfigProperties {
    private String name = "starter";

    private String url = "localhost";

    private String username;

    private String password;

    private Integer count = 1;
}
