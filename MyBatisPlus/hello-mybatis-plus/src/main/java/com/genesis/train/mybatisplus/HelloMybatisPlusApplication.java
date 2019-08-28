package com.genesis.train.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.genesis.train.mybatisplus.mapper")
public class HelloMybatisPlusApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloMybatisPlusApplication.class, args);
	}

}
