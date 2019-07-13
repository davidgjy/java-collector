package org.genesis.javacollector.cache.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: KG
 * @description:
 * @date: Created in 上午9:54 2019/7/13
 * @modified by:
 */
@SpringBootApplication
@EnableSwagger2
public class GsRedisDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(GsRedisDemoApplication.class, args);
    }
}
