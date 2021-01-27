package com.activemq.config;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class ActiveMqConfig {

	@Value("${activemq.broker-url}")
	private String activeMqBrokerUrl;
	
	@Bean("queue1")
	public Queue queue() {
		return new ActiveMQQueue("test.queue1");
	}

	@Bean("queue2")
	public Queue queue2() {
		return new ActiveMQQueue("test.queue2");
	}

	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(activeMqBrokerUrl);
		return factory;
	}

	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(activeMQConnectionFactory());
	}
}
