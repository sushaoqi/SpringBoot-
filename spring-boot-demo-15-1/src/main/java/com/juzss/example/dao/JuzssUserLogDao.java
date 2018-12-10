package com.juzss.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juzss.example.bean.JuzssUserLog;


/**
 * @author wujing
 */
public interface JuzssUserLogDao extends JpaRepository<JuzssUserLog, Integer> {

}
