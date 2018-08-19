package org.genesis.javacollector.spring.aop.main;

import org.genesis.javacollector.spring.aop.proxy.ForumService;
import org.genesis.javacollector.spring.aop.proxy.ForumServiceImpl;
import org.genesis.javacollector.spring.aop.proxy.PerformaceHandler;

import java.lang.reflect.Proxy;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: TestForumServiceProxy
 * @Package org.genesis.javacollector.spring.aop.main
 * @Description: test forum service by proxy
 * @date 2018/8/19 21:24
 */
public class TestForumServiceProxy {
    public static void main(String[] args) {
        // 使用JDK动态代理
        ForumService target = new ForumServiceImpl();
        PerformaceHandler handler = new PerformaceHandler(target);
        ForumService proxy = (ForumService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);
        proxy.removeForum(10);
        proxy.removeTopic(1012);
    }
}
