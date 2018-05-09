package com.genesis.spring;

import com.genesis.spring.beans.MediaService;
import com.genesis.spring.config.MediaConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午5:17 2018/5/9
 * @modified by:
 */

public class JavaScanMain {
    public static void main(String... args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MediaConfig.class);
        MediaService media = ctx.getBean("media", MediaService.class);
        media.save();
    }
}

