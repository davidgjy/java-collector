package com.genesis.spring;

import com.genesis.spring.config.SingerConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import static com.genesis.spring.pojo.Singer.getBean;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: MainApp
 * @Package com.genesis.spring
 * @Description: main app
 * @date 2018/9/19 11:02
 */
public class MainApp {
    public static void main(String... args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(SingerConfiguration.SingerConfig.class);

        getBean("singerOne", ctx);
        getBean("singerTwo", ctx);
        getBean("singerThree", ctx);

        ctx.close();
    }
}
