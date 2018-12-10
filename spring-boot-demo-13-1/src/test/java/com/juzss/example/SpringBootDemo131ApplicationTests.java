package com.juzss.example;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.juzss.example.bean.JuzssUser;
import com.juzss.example.dao.JuzssUserDao;
import com.juzss.example.util.base.Page;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemo131ApplicationTests {

	@Autowired
	private JuzssUserDao juzssUserDao;

	@Test
	public void insert() {
		JuzssUser JuzssUser = new JuzssUser();
		JuzssUser.setName("测试");
		JuzssUser.setCreateTime(new Date());
		int result = juzssUserDao.insert(JuzssUser);
		System.out.println(result);
	}

	@Test
	public void delete() {
		int result = juzssUserDao.deleteById(2);
		System.out.println(result);
	}

	@Test
	public void update() {
		JuzssUser JuzssUser = new JuzssUser();
		JuzssUser.setId(2);
		JuzssUser.setName("测试2");
		JuzssUser.setCreateTime(new Date());
		int result = juzssUserDao.updateById(JuzssUser);
		System.out.println(result);
	}

	@Test
	public void select() {
		JuzssUser result = juzssUserDao.selectById(2);
		System.out.println(result);
	}
	

	@Test
	public void select2() {
		JuzssUser result = juzssUserDao.selectById(7);
		System.out.println(result);
	}
	
	// 分页测试
	@Test
	public void queryForPage(){
		Page<JuzssUser> result = juzssUserDao.queryForPage(1, 20, "测试");
		System.out.println(result.getList());
	}

}
