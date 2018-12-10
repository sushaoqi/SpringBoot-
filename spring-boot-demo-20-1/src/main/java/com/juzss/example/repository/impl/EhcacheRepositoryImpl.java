package com.juzss.example.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.juzss.example.domain.User;
import com.juzss.example.repository.EhcacheRepository;
import com.juzss.example.repository.UserRepository;

//cacheNames为ehcache.xml配置文件内的配置名称
@CacheConfig(cacheNames = {"juzssCache"})
@Repository
public class EhcacheRepositoryImpl implements EhcacheRepository{
	private static final Logger logger = LoggerFactory.getLogger(EhcacheRepository.class);

    @Autowired
    private UserRepository userRepository;

    @CachePut(key = "#p0")
    @Override
    public User save(User user) {
        User savedUser = userRepository.save(user);
        logger.info("新增功能，同步到缓存，直接写入数据库，ID为：" + savedUser.getId());
        return savedUser;
    }

    @Cacheable(key = "#p0")
    @Override
    public User selectById(Integer id) {
        logger.info("查询功能，缓存未找到，直接读取数据库，ID为：" + id);
        return userRepository.findOne(id);
    }

    @CachePut(key = "#p0")
    @Override
    public User updateById(User user) {
        logger.info("更新功能，更新缓存，直接更新数据库，ID为：" + user.getId());
        return userRepository.save(user);
    }

    @CacheEvict(key = "#p0")
    @Override
    public String deleteById(Integer id) {
        logger.info("删除功能，删除缓存，直接删除数据库数据，ID为：" + id);
        userRepository.delete(id);
        return "删除成功";
    }
}
