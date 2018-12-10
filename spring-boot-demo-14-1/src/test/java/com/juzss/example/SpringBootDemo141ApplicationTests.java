package com.juzss.example;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.junit4.SpringRunner;

import com.juzss.example.bean.JuzssUserLog;
import com.juzss.example.dao.JuzssUserLogDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemo141ApplicationTests {

	@Autowired
	private JuzssUserLogDao juzssUserLogDao;

	@Test
	public void insert() {
		JuzssUserLog entity = new JuzssUserLog();
		entity.setUserName("无境");
		entity.setUserIp("192.168.0.1");
		entity.setCreateTime(new Date());
		juzssUserLogDao.save(entity);
	}

	@Test
	public void delete() {
		juzssUserLogDao.delete(1);
	}

	@Test
	public void update() {
		JuzssUserLog entity = new JuzssUserLog();
		entity.setId(2);
		entity.setUserName("无境2");
		entity.setUserIp("192.168.0.1");
		entity.setCreateTime(new Date());
		juzssUserLogDao.save(entity);
	}

	@Test
	public void select() {
		JuzssUserLog result = juzssUserLogDao.findOne(1);
		System.out.println(result);
	}

	@Test
	public void select2() {
		List<JuzssUserLog> result = juzssUserLogDao.findByUserName("无境");
		System.out.println(result);
	}

	@Test
	public void select3() {
		List<JuzssUserLog> result = juzssUserLogDao.findByUserNameAndUserIp("无境", "192.168.0.1");
		System.out.println(result);
	}

	// 分页
	@Test
	public void queryForPage() {
		Pageable pageable = new PageRequest(0, 20, new Sort(new Order(Direction.DESC, "id")));
		Page<JuzssUserLog> result = juzssUserLogDao.findByUserName("无境", pageable);
		System.out.println(result.getContent());
	}

}
