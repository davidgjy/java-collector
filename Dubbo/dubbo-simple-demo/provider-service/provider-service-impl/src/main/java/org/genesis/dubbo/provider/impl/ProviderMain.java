package org.genesis.dubbo.provider.impl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author: KG
 * @description:
 * @date: Created in 3:33 下午 2020/5/22
 * @modified by:
 */

public class ProviderMain {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/provider-service-impl.xml");
        context.start();
        System.in.read();
    }
}
