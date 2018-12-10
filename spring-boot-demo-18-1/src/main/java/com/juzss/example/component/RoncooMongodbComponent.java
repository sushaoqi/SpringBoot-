/**
 * 使用NoSQL数据库-mongodb
 */
package com.juzss.example.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.juzss.example.bean.JuzssUser;

/**
 * @author wujing
 */
@Component
public class RoncooMongodbComponent {

	@Autowired
	private MongoTemplate mongoTemplate;

	public void insert(JuzssUser juzssUser) {
		mongoTemplate.insert(juzssUser);
	}

	public void deleteById(int id) {
		Criteria criteria = Criteria.where("id").in(id);
		Query query = new Query(criteria);
		mongoTemplate.remove(query, JuzssUser.class);
	}
	
	public void updateById(JuzssUser juzssUser) {
		Criteria criteria = Criteria.where("id").in(juzssUser.getId());
		Query query = new Query(criteria);
		Update update = new Update();
		update.set("name", juzssUser.getName());
		update.set("createTime", juzssUser.getCreateTime());
		mongoTemplate.updateMulti(query, update, JuzssUser.class);
	}
	
	public JuzssUser selectById(int id) {
		Criteria criteria = Criteria.where("id").in(id);
		Query query = new Query(criteria);
		return mongoTemplate.findOne(query, JuzssUser.class);
	}
}
