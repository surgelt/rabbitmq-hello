package com.lt.rabbit;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(String name) {
		String context = "hello " +name +" " + new Date();
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("hello2", context);
	}
}