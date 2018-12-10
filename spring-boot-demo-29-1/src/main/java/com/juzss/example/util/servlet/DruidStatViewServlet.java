package com.juzss.example.util.servlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.alibaba.druid.support.http.StatViewServlet;

/**
 * 
 * @author wujing
 */
@WebServlet(urlPatterns = { "/druid/*" }, initParams = { @WebInitParam(name = "loginUsername", value = "juzss"),@WebInitParam(name = "loginPassword", value = "juzss") })
public class DruidStatViewServlet extends StatViewServlet {
	private static final long serialVersionUID = 1L;

}
