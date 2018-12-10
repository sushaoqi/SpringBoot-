package com.juzss.example.dao;

import com.juzss.example.bean.JuzssUser;

/**
 * @author wujing
 */
public interface JuzssUserDao {

	/**
	 * 插入
	 * 
	 * @param roncooUser
	 * @return
	 */
	int insert(JuzssUser juzssUser);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	int deleteById(int id);

	/**
	 * 更新
	 * 
	 * @param juzssUser
	 * @return
	 */
	int updateById(JuzssUser juzssUser);

	/**
	 * 查找
	 * 
	 * @param id
	 * @return
	 */
	JuzssUser selectById(int id);

}
