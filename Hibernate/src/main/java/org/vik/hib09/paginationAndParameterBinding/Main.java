package org.vik.hib09.paginationAndParameterBinding;

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

		// ob.pagination_test();

		ob.parameterBinding_test();
	}

	public void pagination_test() {
		// saving some users
		saveUsers();

		for (int i = 0; i < 4; i++) {
			List<Person> personList = getPaginatedPersons(i * 5, 5);
			System.out.println(personList.get(0).getFirstName());
		}
	}

	public void parameterBinding_test() {
		// saving some users
		saveUsers();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "from Person where personId> :personId and firstName = :firstName";
		Query query = session.createQuery(hql);
		query.setParameter("personId", 12);
		query.setParameter("firstName", "22.firstName");
		List<Person> personList = (List<Person>) query.list();
		for (Person p : personList) {
			System.out.println(p.getFirstName());
		}
		session.getTransaction().commit();
		session.close();

	}

	private List<Person> getPaginatedPersons(int offset, int limit) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from PERSON09");
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		List<Person> personList = (List<Person>) query.getResultList();
		session.getTransaction().commit();
		session.close();

		return personList;
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
