package com.juzss.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.juzss.example.util.filter.CustomerFilter;
import com.juzss.example.util.listener.CustomerListener;
import com.juzss.example.util.servlet.CustomerServlet;

@SpringBootApplication
public class SpringBootDemo101Application {
	
	
	//注册bean
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		return new ServletRegistrationBean(new CustomerServlet(),"/juzss");
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		return  new FilterRegistrationBean(new CustomerFilter());
	}
	
	@Bean
	public ServletListenerRegistrationBean<CustomerListener> servletListenerRegistrationBean(){
		return  new ServletListenerRegistrationBean<CustomerListener>(new CustomerListener());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo101Application.class, args);
	}
}
