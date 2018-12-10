package com.juzss.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 静态资源的使用
 *
 */
@Controller
@RequestMapping(value="/web")
public class WebController {
	
 private static final Logger logger = LoggerFactory.getLogger(WebController.class);

	
   @RequestMapping("/index")
   public String index(ModelMap map) {
	   logger.info("这是controller");
	   map.put("title", "Hello world");
	   return  "index"; //注意,前面不能加/,要么linux系统下会报错
   }
}
