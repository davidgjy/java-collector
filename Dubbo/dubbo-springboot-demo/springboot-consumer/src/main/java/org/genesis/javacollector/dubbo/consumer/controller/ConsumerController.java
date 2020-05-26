package org.genesis.javacollector.dubbo.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.genesis.javacollector.dubbo.provider.api.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: KG
 * @description:
 * @date: Created in 10:51 上午 2020/5/26
 * @modified by:
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class ConsumerController {
    @Reference(version = "1.0-SNAPSHOT")
    private HelloService helloService;

    @GetMapping(value = "/test")
    public void test() {
        String hello = helloService.sayHello("KG2");
        log.info(hello);
    }
}
