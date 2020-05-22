package org.genesis.dubbo.consumer;

import org.genesis.dubbo.provider.api.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: KG
 * @description:
 * @date: Created in 4:12 下午 2020/5/22
 * @modified by:
 */

public class ConsumerMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/consumer-service.xml");
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService.getNameById("9999"));
    }
}

