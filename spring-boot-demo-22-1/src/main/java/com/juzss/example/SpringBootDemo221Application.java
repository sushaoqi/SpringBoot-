package com.juzss.example;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.juzss.example"})
@EnableRabbit
//启用缓存注解
@EnableCaching
public class SpringBootDemo221Application {
	 public static void main(String[] args) {
	        SpringApplication.run(SpringBootDemo221Application.class, args);
	 }
}
