package org.vik.spr08.si.dependentObject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		// Resource r=new ClassPathResource("applicationContext.xml");
		// BeanFactory factory=new XmlBeanFactory(r);
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");

		Employee e = (Employee) factory.getBean("emp8");
		e.displayInfo();

	}
}
