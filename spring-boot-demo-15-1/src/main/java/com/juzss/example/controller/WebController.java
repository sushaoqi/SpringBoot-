/**
 * 使用SQL关系型数据库-事务处理
 */
package com.juzss.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * spring-boot-demo-15-1
 * 
 * @author wujing
 */
@Controller
@RequestMapping(value = "/web")
public class WebController {

	@RequestMapping(value = "index")
	public String index(ModelMap map) {
		map.put("title", "freemarker hello word");
		return "index"; // 开头不要加上/，linux下面会出错
	}

	@RequestMapping(value = "error")
	public String error(ModelMap map) {
		throw new RuntimeException("测试异常");
	}

}
