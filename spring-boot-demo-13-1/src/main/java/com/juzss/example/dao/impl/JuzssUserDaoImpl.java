package com.juzss.example.dao.impl;

import org.springframework.stereotype.Repository;

import com.juzss.example.bean.JuzssUser;
import com.juzss.example.dao.JuzssUserDao;
import com.juzss.example.util.base.JdbcDaoImpl;
import com.juzss.example.util.base.Page;
import com.juzss.example.util.base.Sql;
import com.mysql.jdbc.StringUtils;

/**
 * @author wujing
 */
@Repository
public class JuzssUserDaoImpl extends JdbcDaoImpl implements JuzssUserDao {

	/*@Autowired
	private JdbcTemplate jdbcTemplate;*/

	@Override
	public int insert(JuzssUser JuzssUser) {
		String sql = "insert into juzss_user (name, create_time) values (?, ?)";
		return jdbcTemplate.update(sql, JuzssUser.getName(), JuzssUser.getCreateTime());
	}

	@Override
	public int deleteById(int id) {
		String sql = "delete from juzss_user where id=?";
		return jdbcTemplate.update(sql, id);
	}

	@Override
	public int updateById(JuzssUser JuzssUser) {
		String sql = "update juzss_user set name=?, create_time=? where id=?";
		return jdbcTemplate.update(sql, JuzssUser.getName(), JuzssUser.getCreateTime(), JuzssUser.getId());
	}

	@Override
	public JuzssUser selectById(int id) {
		String sql = "select * from juzss_user where id=?";
		/*return jdbcTemplate.queryForObject(sql, new RowMapper<JuzssUser>() {
			@Override
			public JuzssUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				JuzssUser JuzssUser = new JuzssUser();
				JuzssUser.setId(rs.getInt("id"));
				JuzssUser.setName(rs.getString("name"));
				JuzssUser.setCreateTime(rs.getDate("create_time"));
				return JuzssUser;
			}
		}, id);*/
		
		return queryForObject(sql, JuzssUser.class, id);
	}
	
	@Override
	public Page<JuzssUser> queryForPage(int pageCurrent, int pageSize, String name){
		// 确定参数
		/*String sql = "select * from roncoo_user where name=?";
		return queryForPage(sql.toString(), pageCurrent, pageSize, JuzssUser.class, name);*/
		
		// 若name可能为空，则要进行判定，如下
		/*StringBuffer sql = new StringBuffer("select * from roncoo_user where 1");
		if(!StringUtils.isNullOrEmpty(name)){
			// Sql.checkSql 的作用是防止sql注入
			sql.append(" and name = '").append(Sql.checkSql(name)).append("' ");
		}
		return queryForPage(sql.toString(), pageCurrent, pageSize, JuzssUser.class);*/
		
		// 若要like查询，如下
		StringBuffer sql = new StringBuffer("select * from juzss_user where 1");
		if(!StringUtils.isNullOrEmpty(name)){
			// Sql.checkSql 的作用是防止sql注入
			sql.append(" and name like '%").append(Sql.checkSql(name)).append("%' ");
		}
		return queryForPage(sql.toString(), pageCurrent, pageSize, JuzssUser.class);
	}

}
