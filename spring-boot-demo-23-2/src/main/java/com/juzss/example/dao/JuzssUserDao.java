package com.juzss.example.dao;

import com.juzss.example.bean.JuzssUser;
import com.juzss.example.util.base.Page;

public interface JuzssUserDao {

	int insert(JuzssUser juzssUser);

	int deleteById(int id);

	int updateById(JuzssUser juzssUser);

	JuzssUser selectById(int id);

	Page<JuzssUser> queryForPage(int i, int j, String string);

}
