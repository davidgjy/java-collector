package com.genesis.spring;

import com.genesis.spring.bean.SingerWithJSR250;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: MainApp
 * @Package com.genesis.spring
 * @Description: main app
 * @date 2018/9/19 11:17
 */
public class MainApp {
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        getBean("singerOne", ctx);
        getBean("singerTwo", ctx);
        getBean("singerThree", ctx);

        ctx.close();
    }

    private static SingerWithJSR250 getBean(String beanName, ApplicationContext ctx) {
        try {
            SingerWithJSR250 bean = (SingerWithJSR250) ctx.getBean(beanName);
            System.out.println(bean);
            return bean;
        } catch (BeanCreationException ex) {
            System.out.println("An error occured in bean configuration: "
                    + ex.getMessage());
            return null;
        }
    }
}
