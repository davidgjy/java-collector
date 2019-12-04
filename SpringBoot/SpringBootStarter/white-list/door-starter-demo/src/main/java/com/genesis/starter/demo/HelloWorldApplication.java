package com.genesis.starter.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author : KG
 * description :
 * create date : 2019/12/4 9:37 PM
 * modified by :
 */

@SpringBootApplication
@ComponentScan("com.genesis.starter.demo.*")
@Configuration
@ImportResource(locations = {"classpath:spring-config.xml"})
public class HelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }

}
