package com.juzss.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemo11ApplicationTests {

	private MockMvc mvc;

	@Before
	public void befo() {
		this.mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
	}

	
	
	@Test
	public void contextLoads() throws Exception {
		RequestBuilder request = get("/hello");
		mvc.perform(request).andExpect(status().isOk()).andExpect(content().string("hello Spring Boot!"));
	}
}
