package com.juzss.example.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 使用Spring Session实现集群-redisｓ
 */
@Controller
@RequestMapping(value = "/web")
public class WebController {
	
	private static final Logger logger = LoggerFactory.getLogger(WebController.class);
	
	@RequestMapping(value = "/index")
	public String index(ModelMap map, HttpSession httpSession) {
		map.put("title", "第二个应用：sessionID=" + httpSession.getId());
		logger.info("sessionID=" + httpSession.getId());
		return "index";
	}

	@RequestMapping(value = "error")
	public String error(ModelMap map) {
		throw new RuntimeException("测试异常");
	}

}
