package com.juzss.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;


@SpringBootApplication
@ComponentScan({"com.juzss.example"})
//启用缓存注解
@EnableCaching
@EnableJms 
public class SpringBootDemo211Application {
	 public static void main(String[] args) {
	        SpringApplication.run(SpringBootDemo211Application.class, args);
	 }
}
