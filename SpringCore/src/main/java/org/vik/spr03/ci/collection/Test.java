package org.vik.spr03.ci.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.vik.spr03.ci.collection.Question;

public class Test {
	public static void main(String[] args) {
		ApplicationContext apx = new ClassPathXmlApplicationContext("applicationContext.xml");

		Question q = (Question) apx.getBean("ques3");
		q.displayInfo();

	}
}
