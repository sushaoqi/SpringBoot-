package com.juzss.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
/**
 * 
 * 调用Rest服务,spring-boot-demo-23-2实现代理类
 * 我们这里的测试号改为test模式,即使端口冲突也不影响
 * 这样我们就可以请求spring-boot-demo-23-1里面的内容了
 *
 */
@ServletComponentScan
@SpringBootApplication
public class SpringBootDemo232Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo232Application.class, args);
	}
}
