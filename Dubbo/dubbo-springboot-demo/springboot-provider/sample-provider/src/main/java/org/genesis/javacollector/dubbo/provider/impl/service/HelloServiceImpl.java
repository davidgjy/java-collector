package org.genesis.javacollector.dubbo.provider.impl.service;

import org.apache.dubbo.config.annotation.Service;
import org.genesis.javacollector.dubbo.provider.api.HelloService;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author: KG
 * @description:
 * @date: Created in 10:08 上午 2020/5/26
 * @modified by:
 */
@Service(version = "1.0-SNAPSHOT", interfaceClass = HelloService.class)
public class HelloServiceImpl implements HelloService {
    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String sayHello(String name) {
        return String.format("[%s]: Hello, %s", serviceName, name);
    }
}
