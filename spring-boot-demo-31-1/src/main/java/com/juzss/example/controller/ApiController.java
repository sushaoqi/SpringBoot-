package com.juzss.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juzss.example.bean.JuzssUser;
import com.juzss.example.mapper.JuzssUserMapper;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author wujing
 */
@RestController
@RequestMapping(value = "/api")
public class ApiController {
	@Autowired
	private  JuzssUserMapper juzssUserMapper;

	@ApiOperation(value = "查找", notes = "根据用户ID查找用户")
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public JuzssUser get(@RequestParam(defaultValue = "1") Integer id) {
		return juzssUserMapper.selectByPrimaryKey(id);
	}
	
	@ApiIgnore
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public int delete(@RequestParam(defaultValue = "1") Integer id) {
		return juzssUserMapper.deleteByPrimaryKey(id);
	}
}
