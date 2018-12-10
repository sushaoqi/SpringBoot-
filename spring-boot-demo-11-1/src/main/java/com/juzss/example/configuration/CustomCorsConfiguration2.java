package com.juzss.example.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *全局设置
 */
@SuppressWarnings("deprecation")
@Configuration
public class CustomCorsConfiguration2 extends WebMvcConfigurerAdapter {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/api/**").allowedOrigins("http://localhost:8080");
	}
}
