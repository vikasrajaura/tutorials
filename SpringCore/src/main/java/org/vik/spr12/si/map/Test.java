package org.vik.spr12.si.map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {
	public static void main(String[] args) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);

		Question q = (Question) factory.getBean("ques12");
		q.displayInfo();
	}
}
