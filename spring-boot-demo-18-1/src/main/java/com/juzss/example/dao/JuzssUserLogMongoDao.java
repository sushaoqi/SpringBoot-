package com.juzss.example.dao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.juzss.example.bean.JuzssUserLog;



public interface JuzssUserLogMongoDao extends MongoRepository<JuzssUserLog, Integer>{

	JuzssUserLog findByUserName(String string);
	
	JuzssUserLog findByUserNameAndUserIp(String string, String ip);

	Page<JuzssUserLog> findByUserName(String string, Pageable pageable);
}
