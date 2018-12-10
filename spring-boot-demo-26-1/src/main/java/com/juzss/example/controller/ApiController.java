package com.juzss.example.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juzss.example.component.JuzssJavaMailComponent;

/**
 * 远程调用失败的话请参考https://blog.csdn.net/qq_39299893/article/details/80327294来配置
 */
@RestController
@RequestMapping(value = "/api", method = RequestMethod.POST)
public class ApiController {
	@Autowired
	private JuzssJavaMailComponent component;

	@RequestMapping(value = "mail")
	public String mail(String email) {
		component.sendMail(email);
		return "success";
	}

	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/get")
	public HashMap<String, Object> get(@RequestParam String name) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title", "hello world");
		map.put("name", name);
		return map;
	}
}
