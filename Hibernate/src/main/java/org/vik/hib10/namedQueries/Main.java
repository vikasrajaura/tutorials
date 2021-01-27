package org.vik.hib10.namedQueries;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.vik.util.HibernateUtil;

/**
 * 
 * @author vr250104
 *
 */
public class Main {

	public static void main(String args[]) {
		Main ob = new Main();

		ob.namedQuery_test();
	}

	public void namedQuery_test() {
		// saving some users
		saveUsers();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		// NamedQuery
		Query namedQuery = session.getNamedQuery("personById");
		namedQuery.setParameter(0, 13);
		List<Person> personList = (List<Person>) namedQuery.list();
		for (Person p : personList) {
			System.out.println(p.toString());
		}
		
		// NamedNativeQuery
		Query namedNativeQuery = session.getNamedNativeQuery("personByFirstName");
		namedNativeQuery.setParameter(0, "12.firstName");
		List<Person> personList1 = (List<Person>) namedNativeQuery.list();
		for (Person p : personList1) {
			System.out.println(p.toString());
		}

		session.getTransaction().commit();
		session.close();
		System.out.println("-------------------------------");
	}

	private void saveUsers() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		for (int i = 0; i < 30; i++) {
			Person p = Person.getPerson();
			p.setFirstName(i + "." + p.getFirstName());
			session.save(p);
		}

		session.getTransaction().commit();
		session.close();
	}

}
