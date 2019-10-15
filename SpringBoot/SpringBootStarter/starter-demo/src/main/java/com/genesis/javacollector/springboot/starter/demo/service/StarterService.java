package com.genesis.javacollector.springboot.starter.demo.service;

import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @author: KG
 * @description:
 * @date: Created in 1:38 PM 2019/10/15
 * @modified by:
 */
@Data
@Service
public class StarterService {

    private String serviceName;

    private String url;

    private String password;

    private Integer count;

    public StarterService() {
    }

    public StarterService(String serviceName, String url, String password, Integer count) {
        this.serviceName = serviceName;
        this.url = url;
        this.password = password;
        this.count = count;
    }

    public String showInfo() {
        return String.format("Name: %s\nurl: %s\npassword: %s\ncount: %d\n", serviceName, url, password, count);
    }
}


