package com.juzss.example.component;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * SpringBoot之使用异步消息服务-AMQP（RabbitMQ）
 *
 */
@Component
public class AmqpComponent {

	@Autowired
	private AmqpTemplate amqpTemplate;

	public void send(String msg) {
		this.amqpTemplate.convertAndSend("juzss.queue", msg);
	}

	@RabbitListener(queues = "juzss.queue")
	public void receiveQueue(String text) {
		System.out.println("接受到：" + text);
	}
}
