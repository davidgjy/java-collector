package com.genesis.spring;

import com.genesis.spring.beans.MediaService;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午5:17 2018/5/9
 * @modified by:
 */

public class AppContextMain {
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-config.xml");
        ctx.refresh();
        MediaService media = ctx.getBean("media", MediaService.class);
        media.save();
        ctx.close();
    }
}

