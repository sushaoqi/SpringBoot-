package com.juzss.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 通过ServletContextInitializer直接注册
 * web应用开发-Servlets, Filters, listeners
 */
@ServletComponentScan
@SpringBootApplication
public class SpringBootDemo103Application{
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo103Application.class, args);
	}

}
