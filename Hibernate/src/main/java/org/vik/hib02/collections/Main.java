package org.vik.hib02.collections;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.vik.util.HibernateUtil;

public class Main {

	public static void main(String args[]) {
		Main ob = new Main();
		ob.test();
	}

	public void test() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Person p1 = Person.getPerson();

		List<Chair> chairs = new ArrayList<>();
		Chair ch1 = Chair.getChair();
		chairs.add(ch1);
		
		List<Book> books = new ArrayList<>();
		Book b1 = Book.getBook();
		books.add(b1);
		

		List<String> pens = new ArrayList<>();
		pens.add("Blue Pen");
		pens.add("Red Pen");

		p1.setPersonChairList(chairs);
		p1.setPersonBookList(books);
		p1.setPens(pens);
		
		session.beginTransaction();
		session.save(p1);
		session.save(b1);
		session.getTransaction().commit();
		session.close();

	}

}
