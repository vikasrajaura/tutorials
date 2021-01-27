package org.vik.spr00.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ "classpath*:applicationContext.xml" })
public class XmlConfiguration {
	
	@Bean
	public String dummyBeanC() {
		return "dummyBeanC";
	}
	
	@Bean
	public String someDummyBeanD() {
		return "dummyBeanD";
	}

}
