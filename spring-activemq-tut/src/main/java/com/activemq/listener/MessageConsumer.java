package com.activemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.annotation.JmsListeners;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

	//@JmsListener(destination = "test.queue1")
	@JmsListeners(value = {@JmsListener(destination = "test.queue1"), @JmsListener(destination = "test.queue2")})
	public void consume(String msg) {
		System.out.println("Received Msg: " + msg);
	}
	
	
	@JmsListener(destination = "test.queue1")
	public void consume1(String msg) {
		System.out.println("Received Msg 1: " + msg);
	}
}
