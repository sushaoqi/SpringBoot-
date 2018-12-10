package com.juzss.example.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juzss.example.bean.JuzssUser;
import com.juzss.example.bean.JuzssUserLog;
import com.juzss.example.dao.JuzssUserDao;
import com.juzss.example.dao.JuzssUserLogDao;

/**
 * @author wujing
 */
@Service
public class UserService {

	@Autowired
	private JuzssUserDao juzssUserDao;

	@Autowired
	private JuzssUserLogDao juzssUserLogDao;

	/**
	 * 用户注册
	 * 
	 * @return
	 */
	@Transactional
	public String register(String name, String ip) {
		// 1.添加用户
		JuzssUser juzssUser = new JuzssUser();
		juzssUser.setName(name);
		juzssUser.setCreateTime(new Date());
		juzssUserDao.insert(juzssUser);

		// 测试使用
		boolean flag = true;
		if (flag) {
//			throw new RuntimeException();
		}

		// 2.添加注册日志
		JuzssUserLog juzssUserLog = new JuzssUserLog();
		juzssUserLog.setUserName(name);
		juzssUserLog.setUserIp(ip);
		juzssUserLog.setCreateTime(new Date());
		juzssUserLogDao.save(juzssUserLog);

		return "success";
	}

}
