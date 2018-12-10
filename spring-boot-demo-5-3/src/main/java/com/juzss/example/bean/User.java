/**
 *  1. Properties配置多环境，需要添加多个配置文件，YAML只需要一个配件文件
 *	2.书写格式的差异，yaml相对比较简洁，优雅
 *  3. YAML的缺点：不能通过@PropertySource注解加载。如果需要使用@PropertySource注解的方式加载值，那就要使用properties文件。
 */
package com.juzss.example.bean;

import java.util.Date;

/**
 * 实体类
 * 
 * @author wujing
 */
public class User {
	private int id;
	private String name;
	private Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
