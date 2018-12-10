package com.juzss.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
/**
 * http://localhost:8080/api/select
 * http://localhost:8080/druid/login.html
 */
@ServletComponentScan
@SpringBootApplication
@ImportResource(locations = { "classpath:druid-bean.xml" })
public class SpringBootDemo301Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo301Application.class, args);
	}
}
