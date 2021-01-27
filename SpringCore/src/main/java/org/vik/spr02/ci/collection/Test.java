package org.vik.spr02.ci.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext apx = new ClassPathXmlApplicationContext("applicationContext.xml");

		Question q = (Question) apx.getBean("ques2");
		q.displayInfo();

	}
}
