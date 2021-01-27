package org.vik.hib01.simple;

import org.hibernate.Session;
import org.vik.util.HibernateUtil;
import org.vik.vo.Address;

public class Main {

	public static void main(String args[]) {
		Main ob = new Main();
		ob.test();
	}

	
	public void test() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Person p1 = Person.getPerson();
		p1.setAddress(Address.getAddress());

		session.beginTransaction();
		session.save(p1);
		session.getTransaction().commit();
		session.close();
		
	}
	
}
