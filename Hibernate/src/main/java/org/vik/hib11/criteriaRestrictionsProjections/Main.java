package org.vik.hib11.criteriaRestrictionsProjections;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
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
		// saving some users
		ob.saveUsers();

		ob.criteria_test();

	}

	public void criteria_test() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Criteria cr = session.createCriteria(Person.class);
		cr.add(Restrictions.eq("personId", 5));
		List<Person> pl = (List<Person>) cr.list();

		//pl.forEach(p -> System.out.println(p));

		session.getTransaction().commit();
		session.close();

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

}
