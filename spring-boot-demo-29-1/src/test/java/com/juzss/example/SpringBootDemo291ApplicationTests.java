package com.juzss.example;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.juzss.example.bean.JuzssUser;
import com.juzss.example.mapper.JuzssUserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemo291ApplicationTests {

	@Autowired
	private JuzssUserMapper mapper;

	@Test
	public void insert() {
		JuzssUser juzssUser = new JuzssUser();
		juzssUser.setName("测试");
		juzssUser.setCreateTime(new Date());
		int result = mapper.insert(juzssUser);
		System.out.println(result);
	}
	@Test 
    public void select() { 
	  JuzssUser result = mapper.selectByPrimaryKey(3); 
	  System.out.println(result); 
	} 


}
