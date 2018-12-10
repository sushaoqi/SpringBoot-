package com.juzss.example.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juzss.example.bean.JuzssUser;
import com.juzss.example.mapper.JuzssUserMapper;

/**
 * @author wujing
 */
@RestController
@RequestMapping(value = "/api")
public class ApiController {
	@Autowired
	private  JuzssUserMapper juzssUserMapper;

	
	
	@RequestMapping(value = "/select",method = RequestMethod.GET)
	public JuzssUser get(@RequestParam(defaultValue = "1") Integer id) {
		return juzssUserMapper.selectByPrimaryKey(id);
	}
}
