package org.vik.spr10.si.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext apx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Question q = (Question) apx.getBean("ques10");
		q.displayInfo();
	}
}
