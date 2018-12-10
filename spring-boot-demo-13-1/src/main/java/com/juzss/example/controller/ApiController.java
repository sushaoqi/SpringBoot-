/**
 * Spring Boot基础教程13-使用SQL关系型数据库-JdbcTemplate
 */
package com.juzss.example.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wujing
 */
@RestController
@RequestMapping(value = "/api", method = RequestMethod.POST)
public class ApiController {

	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/get")
	public HashMap<String, Object> get(@RequestParam String name) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title", "hello world");
		map.put("name", name);
		return map;
	}
}
