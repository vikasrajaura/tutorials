package org.vik.hib08.inheritance.joined;

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
		Session session = HibernateUtil.getSessionFactory().openSession();

		Vehicle veh = Vehicle.getVehicle();
		TwoWheeler tw = TwoWheeler.getTwoWheeler();
		FourWheeler fw = FourWheeler.getFourWheeler();
		
		session.beginTransaction();
		session.save(veh);
		session.save(tw);
		session.save(fw);
		session.getTransaction().commit();
		session.close();

	}

}
