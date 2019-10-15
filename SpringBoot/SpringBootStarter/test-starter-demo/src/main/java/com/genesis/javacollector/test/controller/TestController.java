package com.genesis.javacollector.test.controller;

import com.genesis.javacollector.test.service.TestService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: KG
 * @description:
 * @date: Created in 2:10 PM 2019/10/15
 * @modified by:
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    private TestService testService;

    @ApiOperation(value = "test starter")
    @PostMapping("/test-starter")
    public void testStarter() {
        String result = testService.showInfo();
        log.info(">>>> starter service info \n {} <<<<", result);
    }
}
