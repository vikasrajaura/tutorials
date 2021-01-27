package org.vik.hib12.secondLevelCache;

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

		//ob.criteria_test();
		
		ob.test_queryCache();
	}

	public void criteria_test() {
		// saving some users
		saveUsers();
		System.out.println("------------Testing Criteria-----------");
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		session1.beginTransaction();
		Person p1 = (Person) session1.get(Person.class, 3);
		System.out.println(p1.toString());
		session1.getTransaction().commit();
		session1.close();

		Session session2 = HibernateUtil.getSessionFactory().openSession();
		session2.beginTransaction();
		Person p2 = (Person) session2.get(Person.class, 3);
		System.out.println(p2.toString());
		session2.getTransaction().commit();
		session2.close();

	}

	private void saveUsers() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(new Person("Vikas", "Rajaura", 28, 30000));
		session.save(new Person("Rahul", "Singh", 26, 32000));
		session.save(new Person("Suresh", "Pal", 24, 33000));
		session.save(new Person("Dinesh", "Rajaura", 30, 38000));
		session.save(new Person("Tinku", "Payal", 40, 39000));
		session.save(new Person("Deepa", "Chaudhary", 20, 46000));
		session.save(new Person("Teena", "Kumari", 18, 22000));
		session.save(new Person("Nitu", "Kumari", 25, 28000));
		session.save(new Person("Kamal", "Singh", 22, 26000));

		session.getTransaction().commit();
		session.close();
	}

	public void test_queryCache() {
		// query cache - same query can be cached in SessionFactory
		System.out.println("-----------Query Cache----------");
		Session sess1 = HibernateUtil.getSessionFactory().openSession();
		Query query1 = sess1.createQuery("from StudentDetails st where st.studentId=6 ");
		query1.setCacheable(true);
		List list1 = query1.list();
		sess1.close();

		Session sess2 = HibernateUtil.getSessionFactory().openSession();
		Query query2 = sess2.createQuery("from StudentDetails st where st.studentId=6 ");
		query2.setCacheable(true);
		List list2 = query2.list();
		sess2.close();
		
	}

	
}


