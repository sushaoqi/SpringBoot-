/**
 * 使用NoSQL数据库-mongodb
 */
package com.juzss.example.bean;

import java.util.Date;

/**
 * 用户信息
 * 
 * @author wujing
 */
public class JuzssUser {
	private int id;
	private String name;
	private Date createTime;

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "JuzssUser [id=" + id + ", name=" + name + ", createTime=" + createTime + "]";
	}

}
