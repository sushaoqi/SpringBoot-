package com.juzss.example;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;

import com.juzss.example.util.filter.CustomerFilter;
import com.juzss.example.util.listener.CustomerListener;
import com.juzss.example.util.servlet.CustomerServlet;

/**
 * 通过ServletContextInitializer直接注册
 */
@SpringBootApplication
public class SpringBootDemo102Application implements ServletContextInitializer{
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.addServlet("customServlet", new CustomerServlet()).addMapping("/roncoo");
		servletContext.addFilter("customFilter", new CustomerFilter())
				.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST), true, "customServlet");
		servletContext.addListener(new CustomerListener());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo102Application.class, args);
	}

}
