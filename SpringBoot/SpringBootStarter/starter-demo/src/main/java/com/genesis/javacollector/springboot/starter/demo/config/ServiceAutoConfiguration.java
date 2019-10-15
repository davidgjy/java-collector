package com.genesis.javacollector.springboot.starter.demo.config;

import com.genesis.javacollector.springboot.starter.demo.service.StarterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: KG
 * @description:
 * @date: Created in 1:40 PM 2019/10/15
 * @modified by:
 */
@Configuration
@EnableConfigurationProperties(ServiceConfigProperties.class)
public class ServiceAutoConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceAutoConfiguration.class);

    @Autowired
    private ServiceConfigProperties serviceConfigProperties;

    @Bean("starterService")
    public StarterService starterService() {
        LOGGER.info(">>>> starter service start <<<<");
        StarterService starterService = new StarterService();

        starterService.setCount(serviceConfigProperties.getCount());
        starterService.setUrl(serviceConfigProperties.getUrl());
        starterService.setPassword(serviceConfigProperties.getPassword());
        starterService.setServiceName(serviceConfigProperties.getName());

        return starterService;
    }
}
