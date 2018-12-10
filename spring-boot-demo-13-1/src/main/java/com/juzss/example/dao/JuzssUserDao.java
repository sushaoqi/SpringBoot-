/**
 * Spring Boot基础教程13-使用SQL关系型数据库-JdbcTemplate
 */
package com.juzss.example.dao;

import com.juzss.example.bean.JuzssUser;
import com.juzss.example.util.base.Page;

/**
 * @author wujing
 */
public interface JuzssUserDao {

	/**
	 * 插入
	 * 
	 * @param JuzssUser
	 * @return
	 */
	int insert(JuzssUser JuzssUser);

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
	 * @param JuzssUser
	 * @return
	 */
	int updateById(JuzssUser JuzssUser);

	/**
	 * 查找
	 * 
	 * @param id
	 * @return
	 */
	JuzssUser selectById(int id);

	/**
	 * @return
	 */
	Page<JuzssUser> queryForPage(int pageCurrent, int pageSize, String name);

}
