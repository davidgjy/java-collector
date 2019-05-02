package com.genesis.poi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableScheduling
@EnableSwagger2
public class ExcelDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcelDemoApplication.class, args);
	}
}
