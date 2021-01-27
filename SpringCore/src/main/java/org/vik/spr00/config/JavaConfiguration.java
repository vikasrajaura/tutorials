package org.vik.spr00.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfiguration {
	
	@Bean
	public String dummyBeanA() {
		return "dummyBeanA";
	}
	
	@Bean
	public String someDummyBeanB() {
		return "dummyBeanB";
	}

}
