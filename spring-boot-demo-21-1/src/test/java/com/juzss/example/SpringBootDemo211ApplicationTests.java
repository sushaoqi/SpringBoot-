package com.juzss.example;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.juzss.example.jms.Producer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemo211ApplicationTests {

	@Autowired
	private Producer producer;

	@Test
	public void contextLoads() {

		Destination destination = new ActiveMQQueue("mytest.queue");

		for (int i = 0; i < 5; i++) {
			producer.sendMessage(destination, "生产者发送了消息" + i);
		}

	}

}
