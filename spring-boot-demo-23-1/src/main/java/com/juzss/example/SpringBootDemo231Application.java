package com.juzss.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.juzss.example"})
//启用缓存注解
@EnableCaching
public class SpringBootDemo231Application {
	 public static void main(String[] args) {
	        SpringApplication.run(SpringBootDemo231Application.class, args);
	 }
}
