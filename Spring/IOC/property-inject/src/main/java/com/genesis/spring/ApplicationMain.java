package com.genesis.spring;

import com.genesis.spring.beans.MediaService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: ApplicationMain
 * @Package com.genesis.spring
 * @Description: applicaion main class
 * @date 2018/5/25 16:03
 */
public class ApplicationMain {
    public static void main(String... args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        MediaService media = ctx.getBean("media", MediaService.class);
        media.save();
        ((ClassPathXmlApplicationContext) ctx).close();
    }
}
