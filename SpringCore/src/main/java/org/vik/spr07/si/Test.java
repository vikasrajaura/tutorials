package org.vik.spr07.si;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.*;

public class Test {
public static void main(String[] args) {
	
	Resource r=new ClassPathResource("applicationContext.xml");
	BeanFactory factory=new XmlBeanFactory(r);
	
	Employee e=(Employee)factory.getBean("emp7");
	e.display();
	}
}

