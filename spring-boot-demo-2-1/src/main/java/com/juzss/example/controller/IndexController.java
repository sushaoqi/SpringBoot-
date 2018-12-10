package com.juzss.example.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juzss.example.bean.User;

@RestController
@RequestMapping(value="/index")
public class IndexController {
	
	
	@Value(value= "${baidu.secret}")
	private String secret;
	
	@Value(value = "${baidu.number}")
	private int  number;
	
	@Value(value = "${baidu.desc}")
	public String desc;
   
    
	@RequestMapping
	public String index() {
		return "Hello World!";
	}
	
	@RequestMapping(value = "/get")
	public Map<String, Object> get(@RequestParam String name) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("name", name);
		map.put("value", "hello world!");
		map.put("secret",secret);
		map.put("number", number);
		map.put("desc", desc);
		return map;
	}
	
	
	@RequestMapping(value="/find/{id}/{name}")
	public User find(@PathVariable int id,@PathVariable String name) {
		User  u = new User();
		u.setId(id);
		u.setName(name);
		u.setDate(new Date());
		System.out.println(u.getDate());
		return u;
	}
}
