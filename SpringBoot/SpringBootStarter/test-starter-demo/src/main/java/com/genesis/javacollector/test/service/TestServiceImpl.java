package com.genesis.javacollector.test.service;

import com.genesis.javacollector.springboot.starter.demo.service.StarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: KG
 * @description:
 * @date: Created in 2:14 PM 2019/10/15
 * @modified by:
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private StarterService starterService;

    @Override
    public String showInfo() {
        return starterService.showInfo();
    }
}
