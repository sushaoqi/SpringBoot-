package com.juzss.example.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.juzss.example.domain.User;
import com.juzss.example.repository.EhcacheRepository;
/**
 * 使用Caching-EhCache
 * 调用REST服务-如何使用代理
 */
@Controller
@RequestMapping("/ehcache")
public class EhcacheController {
	@Autowired
    private EhcacheRepository ehcacheRepository;

    @RequestMapping("/save")
    @ResponseBody
    public User save() {
        User user = new User();
        user.setName("juzss");
        user.setAge(20);
        user.setAddress("xiaosu");
        user.setCreateTime(new Date());
        return ehcacheRepository.save(user);
    }

    @RequestMapping("/select")
    @ResponseBody
    public User get(@RequestParam(defaultValue = "1") Integer id) {
        return ehcacheRepository.selectById(id);
    }

    @RequestMapping("/update")
    @ResponseBody
    public User update(@RequestParam(defaultValue = "1") Integer id) {
        User user = ehcacheRepository.selectById(id);
        user.setName("TestName");
        user.setCreateTime(new Date());
        return ehcacheRepository.updateById(user);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam(defaultValue = "1") Integer id) {
        return ehcacheRepository.deleteById(id);
    }
}
