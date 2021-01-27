package org.vik.hib03.oneToOne;

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
		ob.test();
	}

	public void test() {

		Person p1 = Person.getPerson();
		Vehicle v1 = Vehicle.getVehicle();
		p1.setVehicle(v1);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(p1);
		session.save(v1);
		session.getTransaction().commit();
		session.close();
		

	}

	/**
	 * To save vehicle entity automatically when person p1 is saved.
	 * We can use persist method for saving p1 and v1 will be saved
	 * automatically, if we are using cascade={CascadeType.PERSIST} 
	 * in @OneToOne
	 */
}
