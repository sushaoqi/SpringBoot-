package com.juzss.example.controller;
/**
 * 一、	Web开发经常会遇到跨域问题，解决方案有：jsonp，iframe,CORS等等 CORS与JSONP相比  
	1、	JSONP只能实现GET请求，而CORS支持所有类型的HTTP请求。 
	2、	使用CORS，开发者可以使用普通的XMLHttpRequest发起请求和获得数据，比起JSONP有更好的错误处理。 
	3、	JSONP主要被老的浏览器支持，它们往往不支持CORS，而绝大多数现代浏览器都已经支持了CORS 
	
	这里我们使用的跨域请求:
	  第一步:首先我把spring-boot-demo-11-1的 src/main/resources下面的application.properties
	  spring.profiles.active=java改成 spring.profiles.active=test
	  其实也不要改的,但是为了测试,改为test环境的端口是8081,当然也可以改成生产模式,端口不一样就可以了
	   
	  先启动src/main/java下面的com.juzss.example的SpringBootDemo111Application这里的端口是8081了
	  访问http://localhost:8081/web/index 就访问首页的内容了
	  
	  然后在spring-boot-demo-10-3中启动rc/main/java下面的com.juzss.example的SpringBootDemo103Application这里
	  的模式为开发模式为8080所以,这样我们就可以实现跨域请求了,其实跨域请求的实现的代码在
	  spring-boot-demo-10-3下面的src/main/resources/templates的index.ftl,
	  $.ajax({ 
      	 	url: "http://localhost:8081/api/get",
      	    type: "POST",
      	    data: {
      	          name: "测试" 
      	     }, 
            success: function(data, status, xhr) { 
                   console.log(data); 
                   alert(data.name); 
             } 
	  
	 })  
	 代码
 */
import java.util.HashMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系密度设置
 */
@RestController
@RequestMapping(value = "/api")
public class ApiController {

	@CrossOrigin(origins="http://localhost:8080")
	@RequestMapping(value = "/get",method=RequestMethod.POST)
	public HashMap<String, Object> get(@RequestParam String name) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title", "hello world");
		map.put("name", name);
		return map;
	}
}
