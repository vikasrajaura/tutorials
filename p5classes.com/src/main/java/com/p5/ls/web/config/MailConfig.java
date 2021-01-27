package com.p5.ls.web.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.p5.ls.web")
@PropertySource(value = { "classpath:application.properties" })
public class MailConfig  {

	@Autowired
	private Environment env;
	
	@Bean
	public JavaMailSender getJavaMailSender() {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost(env.getProperty("spring.mail.host"));
	    mailSender.setPort(Integer.valueOf(env.getProperty("spring.mail.port")));
	    //mailSender.setPort(25);
	    mailSender.setUsername(env.getProperty("spring.mail.username"));
	    mailSender.setPassword(env.getProperty("spring.mail.password"));
	    mailSender.setProtocol(env.getProperty("spring.mail.properties.mail.transport.protocol"));

	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	    
	  /*  
	    props.put("mail.smtp.user", "rajauravikas@gmail.com");
	    props.put("mail.smtp.host", "Nothing*1#");
	    props.put("mail.smtp.port", 547);
	    

	    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.socketFactory.fallback", "false");
	    */
	    return mailSender;	    
	}
}
