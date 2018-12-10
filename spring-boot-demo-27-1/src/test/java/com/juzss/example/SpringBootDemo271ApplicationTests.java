package com.juzss.example;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.protocol.HttpContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.juzss.example.bean.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemo271ApplicationTests {
	
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	/**
	 * get请求
	 */
	@Test
	public void getForObject() {
		User user = restTemplateBuilder.build().getForObject("http://localhost:8080/rest/update/{id}", User.class, 6);
		System.out.println(user);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", 7);
		user = restTemplateBuilder.build().postForObject("http://localhost:8080/rest/update", map, User.class);
		System.out.println(user);
		
	
		String result = restTemplateBuilder.additionalCustomizers(new ProxyCustomizer()).build()
				.getForObject("http://www.tenxun.com", String.class);
		System.out.println(result);
	}
	
	
	static class ProxyCustomizer implements RestTemplateCustomizer {
		@Override
		public void customize(RestTemplate restTemplate) {
			String proxyHost = "103.15.51.160";
			int proxyPort = 8080;

			HttpHost proxy = new HttpHost(proxyHost, proxyPort);
			HttpClient httpClient = HttpClientBuilder.create().setRoutePlanner(new DefaultProxyRoutePlanner(proxy) {
				@Override
				public HttpHost determineProxy(HttpHost target, HttpRequest request, HttpContext context)
						throws HttpException {
//					System.out.println(target.getHostName());
					return super.determineProxy(target, request, context);
				}
			}).build();
			HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
					httpClient);
			httpComponentsClientHttpRequestFactory.setConnectTimeout(10000);
			httpComponentsClientHttpRequestFactory.setReadTimeout(60000);
			restTemplate.setRequestFactory(httpComponentsClientHttpRequestFactory);
		}
	}

//	@Autowired
//	private JuzssUserLogDao juzssUserLogDao;
//
//	@Test
//	public void insert() {
//		JuzssUserLog entity = new JuzssUserLog();
//		entity.setUserName("无境");
//		entity.setUserIp("192.168.0.1");
//		entity.setCreateTime(new Date());
//		juzssUserLogDao.save(entity);
//	}
//
//	@Test
//	public void delete() {
//		juzssUserLogDao.delete(3);
//	}
//
//	@Test
//	public void update() {
//		JuzssUserLog entity = new JuzssUserLog();
//		entity.setId(2);
//		entity.setUserName("无境2");
//		entity.setUserIp("192.168.0.1");
//		entity.setCreateTime(new Date());
//		juzssUserLogDao.save(entity);
//	}
//
//	@Test
//	public void select() {
//		JuzssUserLog result = juzssUserLogDao.findOne(1);
//		System.out.println(result);
//	}
//
//	@Test
//	public void select2() {
//		List<JuzssUserLog> result = juzssUserLogDao.findByUserName("无境");
//		System.out.println(result);
//	}
//
//	@Test
//	public void select3() {
//		List<JuzssUserLog> result = juzssUserLogDao.findByUserNameAndUserIp("无境", "192.168.0.1");
//		System.out.println(result);
//	}
//
//	// 分页
//	@Test
//	public void queryForPage() {
//		Pageable pageable = new PageRequest(0, 20, new Sort(new Order(Direction.DESC, "id")));
//		Page<JuzssUserLog> result = juzssUserLogDao.findByUserName("无境", pageable);
//		System.out.println(result.getContent());
//	}

}
