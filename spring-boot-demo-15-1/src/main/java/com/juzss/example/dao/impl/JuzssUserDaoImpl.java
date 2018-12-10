/**
 * 使用SQL关系型数据库-事务处理
 */
package com.juzss.example.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.juzss.example.bean.JuzssUser;
import com.juzss.example.dao.JuzssUserDao;



/**
 * @author wujing
 */
@Repository
public class JuzssUserDaoImpl implements JuzssUserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(JuzssUser juzssUser) {
		String sql = "insert into juzss_user (name, create_time) values (?, ?)";
		return jdbcTemplate.update(sql, juzssUser.getName(), juzssUser.getCreateTime());
	}

	@Override
	public int deleteById(int id) {
		String sql = "delete from juzss_user where id=?";
		return jdbcTemplate.update(sql, id);
	}

	@Override
	public int updateById(JuzssUser juzssUser) {
		String sql = "update juzss_user set name=?, create_time=? where id=?";
		return jdbcTemplate.update(sql,juzssUser.getName(), juzssUser.getCreateTime(), juzssUser.getId());
	}

	@Override
	public JuzssUser selectById(int id) {
		String sql = "select * from juzss_user where id=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<JuzssUser>() {
			@Override
			public JuzssUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				JuzssUser juzssUser = new JuzssUser();
				juzssUser.setId(rs.getInt("id"));
				juzssUser.setName(rs.getString("name"));
				juzssUser.setCreateTime(rs.getDate("create_time"));
				return juzssUser;
			}
		}, id);
	}

}
