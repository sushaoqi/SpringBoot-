package com.juzss.example.bean;

import java.util.Date;
/**
 * 使用SQL关系型数据库-h2嵌入式数据库的使用
 * @author Shinelon
 *  1.端点暴露的方式取决于你采用的监控方式。如果使用HTTP监控，端点的ID映射到一个URL。例如，默认情况下，health端点将被映射到/health。
	2.端点会默认有敏感度，根据不同的敏感度是否需要提供用户密码认证
	3.如果没启用web安全，则敏感度高的会禁用
	4.可以通过配置文件进行配置敏感度
	5.默认情况下，除了shutdown外的所有端点都是启用的。
 *
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
