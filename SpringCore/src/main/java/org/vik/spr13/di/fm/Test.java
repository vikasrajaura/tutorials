package org.vik.spr13.di.fm;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {
	public static void main(String[] args) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);

		Calculator cal = (Calculator) factory.getBean("calc");
		System.out.println(cal.add(10, 12));
	}
}
