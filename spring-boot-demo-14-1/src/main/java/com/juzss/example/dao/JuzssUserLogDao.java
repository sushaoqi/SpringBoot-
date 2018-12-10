/**
 * -使用SQL关系型数据库-Spring-data-jpa
 */
package com.juzss.example.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.juzss.example.bean.JuzssUserLog;

/**
 * @author wujing
 */
public interface JuzssUserLogDao extends JpaRepository<JuzssUserLog, Integer> {

	/**
	 * @param string
	 * @return
	 */
	@Query(value = "select u from JuzssUserLog u where u.userName=?1")
	List<JuzssUserLog> findByUserName(String userName);

	/**
	 * @param string
	 * @param string2
	 * @return
	 */
	List<JuzssUserLog> findByUserNameAndUserIp(String string, String string2);

	/**
	 * @param exampl
	 * @param pageable
	 * @return
	 */
	Page<JuzssUserLog> findByUserName(String userName, Pageable pageable);

}
