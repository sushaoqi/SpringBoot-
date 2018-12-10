package com.juzss.example.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.juzss.example.domain.User;
import com.juzss.example.repository.EhcacheRepository;
import com.juzss.example.repository.UserRepository;

/**
 * @author wujing
 */
@RestController
@RequestMapping(value = "/rest")
public class RestJuzssController {

	@Autowired
    private EhcacheRepository ehcacheRepository;
	
	
	@RequestMapping("/save")
    @ResponseBody
    public User save() {
        User user = new User();
        user.setName("测试");
        user.setUserName("测试2");
        user.setAge(20);
        user.setUserIp("192.168.10.4");
        user.setAddress("xiaosu");
        user.setCreateTime(new Date());
        return ehcacheRepository.save(user);
    }


	@RequestMapping(value = "/update")
	@ResponseBody
	public User update(@RequestBody JsonNode jsonNode) {
		System.out.println("jsonNode=" + jsonNode);
		User user = ehcacheRepository.selectById(jsonNode.get("id").asInt(1));
		if(user == null){
			user = new User();
		}
		user.setUserName("测试");
		user.setCreateTime(new Date());
		user.setUserIp("192.168.1.1");
		ehcacheRepository.updateById(user);
		return user;
	}

	@RequestMapping(value = "/update/{id}")
	@ResponseBody
	public User update2(@PathVariable(value = "id") Integer id) {
		User user = ehcacheRepository.selectById(id);
		if(user == null){
			user = new User();
		}
		user.setUserName("测试");
		user.setCreateTime(new Date());
		user.setUserIp("192.168.1.1");
		ehcacheRepository.updateById(user);
		return user;
	}

}