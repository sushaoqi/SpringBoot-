package com.juzss.example.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * amqp队列配置
 * 
 */
@Configuration
public class AmqpConfiguration {
	@Bean
	public Queue queue() {
		return new Queue("juzss.queue");
	}
}
