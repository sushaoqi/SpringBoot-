package com.juzss.example;

import java.util.Date;

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
import com.juzss.example.dao.JuzssUserLogMongoDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemo181ApplicationTests {

	/*@Autowired
	private JuzssMongodbComponent juzssMongodbComponent;

	@Test
	public void set() {
		JuzssUser juzssUser = new JuzssUser();
		juzssUser.setId(1);
		juzssUser.setName("无境1");
		juzssUser.setCreateTime(new Date());
		juzssMongodbComponent.insert(juzssUser);
	}

	@Test
	public void select() {
		System.out.println(juzssMongodbComponent.selectById(1));
	}
	
	@Test
	public void update() {
		JuzssUser juzssUser = new JuzssUser();
		juzssUser.setId(1);
		juzssUser.setName("测试修改");
		juzssUser.setCreateTime(new Date());
		roncooMongodbComponent.updateById(juzssUser);
		System.out.println(juzssMongodbComponent.selectById(1));
	}
	
	@Test
	public void delete() {
		juzssMongodbComponent.deleteById(1);
	}*/
	
	@Autowired
	private JuzssUserLogMongoDao juzssUserLogMongoDao;

	@Test
	public void insert() {
		JuzssUserLog entity = new JuzssUserLog();
		entity.setId(1);
		entity.setUserName("无境");
		entity.setUserIp("192.168.0.1");
		entity.setCreateTime(new Date());
		juzssUserLogMongoDao.save(entity);
		System.out.println(juzssUserLogMongoDao.findOne(1));
	}

	@Test
	public void delete() {
		juzssUserLogMongoDao.delete(1);
	}

	@Test
	public void update() {
		JuzssUserLog entity = new JuzssUserLog();
		entity.setId(2);
		entity.setUserName("无境2");
		entity.setUserIp("192.168.0.1");
		entity.setCreateTime(new Date());
		juzssUserLogMongoDao.save(entity);
	}

	@Test
	public void select() {
		JuzssUserLog result = juzssUserLogMongoDao.findOne(1);
		System.out.println(result);
	}

	@Test
	public void select2() {
		JuzssUserLog result = juzssUserLogMongoDao.findByUserName("无境2");
		System.out.println(result);
	}

	// 分页
	@Test
	public void queryForPage() {
		Pageable pageable = new PageRequest(0, 20, new Sort(new Order(Direction.DESC, "id")));
		// Page<RoncooUserLog> result = roncooUserLogDao.findByUserName("无境2", pageable);
		Page<JuzssUserLog> result = juzssUserLogMongoDao.findAll(pageable);
		System.out.println(result.getContent());
	}

}
