package com.juzss.example.jms;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer2 {
	// 使用JmsListener配置消费者监听的队列，其中text是接收到的消息  
    @JmsListener(destination = "mytest.queue")  
    public void receiveQueue(String text) {  
        System.out.println("Consumer2收到的报文为:"+text); 
        System.out.println("================="); 
    }  
}
