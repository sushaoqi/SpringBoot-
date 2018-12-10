package com.juzss.example.repository;

import com.juzss.example.domain.User;

public interface EhcacheRepository {
	/**
     * 增加用户
     * @param user 用户
     * @return 增加后的用户
     */
    User save(User user);

    /**
     * 查询用户
     * @param id 主键
     * @return 用户
     */
    User selectById(Integer id);

    /**
     * 更新用户
     * @param user 更新的用户
     * @return 用户
     */
    User updateById(User user);

    /**
     * 删除用户
     * @param id 主键
     * @return 删除状态
     */
    String deleteById(Integer id);
}
