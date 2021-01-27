package com.activemq.producer;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class MessageProducer {

	@Autowired
	JmsTemplate jmsTemplate;
	
	@Autowired
	Queue queue1;

	@Autowired
	Queue queue2;

	@GetMapping("/publis1/{msg}")
	public String publis1(@PathVariable("msg") String msg) {
		jmsTemplate.convertAndSend(queue1, msg);

		return "Published Successfully.";
	}
	
	@GetMapping("/publis2/{msg}")
	public String publis2(@PathVariable("msg") String msg) {
		jmsTemplate.convertAndSend(queue2, msg);

		return "Published Successfully..";
	}
}
