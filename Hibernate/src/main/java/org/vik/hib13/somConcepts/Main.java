package org.vik.hib13.somConcepts;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.vik.util.HibernateUtil;

/**
 * 
 * @author vr250104
 *
 */
public class Main {

	public static void main(String args[]) {
		Main ob = new Main();
		//ob.test_eagerLoading();

		//ob.test_dirtyChecking();
		ob.test_merge();
	}

	// eager loading
	public void test_eagerLoading() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Person p1 = Person.getPerson();

		// add vehicle list
		List<Vehicle> vehicles = new ArrayList<>();
		Vehicle v1 = Vehicle.getVehicle();
		Vehicle v2 = Vehicle.getVehicle();
		vehicles.add(v1);
		vehicles.add(v2);
		p1.setVehicles(vehicles);

		session.persist(p1);
		// session.save(v1);
		// session.save(v2);
		session.getTransaction().commit();
		session.close();

		Session sess1 = HibernateUtil.getSessionFactory().openSession();
		sess1.beginTransaction();
		List<Person> pList = sess1.createQuery("from PERSON13").list();

		sess1.getTransaction().commit();
		sess1.close();

		// now the session is closed, and we are able to get vehicles from
		// person object
		// it means these vehicles are eagerly loaded.
		for (Vehicle v : pList.get(0).getVehicles()) {
			System.out.println(v.getVehicleName());
		}

	}

	// test dirty checking
	// any changes in the persistent entity is automatically saved in hibernate.
	public void test_dirtyChecking() {
		System.out.println("..........Testing Dirty Checking............");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Person p1 = new Person();
		p1.setPersonId(20);
		p1.setFirstName("Hello");

		session.save(p1);

		// now make any change in p1
		p1.setFirstName("Vikas");
		session.getTransaction().commit();
		session.close();
		System.out.println(p1.getPersonId());
		Session sess1 = HibernateUtil.getSessionFactory().openSession();
		sess1.beginTransaction();
		Person p = sess1.get(Person.class, 20);
		System.out.println(p.getFirstName());

		sess1.getTransaction().commit();
		sess1.close();

	}

	// test merge
	public void test_merge() {
		System.out.println("..........Testing merge()............");
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		session1.beginTransaction();
		Person p1 = new Person();
		p1.setPersonId(31);
		p1.setFirstName("Hello");
		session1.save(p1);
		session1.getTransaction().commit();
		session1.close();
		
		//p1 object is in detached state now make some changes in p1 object
		p1.setFirstName("Vikas");

		// now again get same object to load it in session and merge with p1.
		Session session2 = HibernateUtil.getSessionFactory().openSession();
		session2.beginTransaction();
		Person p2 = session2.get(Person.class, 31);
		session2.evict(p2);
		//session2.merge(p1);
		session2.update(p1); // in this case update method throws exception
		session2.getTransaction().commit();
		session2.close();
		// now changes of p1 is merged and saved in DB.
		
		// lets check the changes in DB
		Session session3 = HibernateUtil.getSessionFactory().openSession();
		session3.beginTransaction();
		Person p3 = session3.get(Person.class, 31);
		session3.getTransaction().commit();
		session3.close();
		System.out.println(p3.getFirstName());
	}

}