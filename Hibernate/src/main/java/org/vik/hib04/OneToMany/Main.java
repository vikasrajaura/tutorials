package org.vik.hib04.OneToMany;

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
		ob.test();
	}

	public void test() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Person p1 = Person.getPerson();

		// add vehicle list
		List<Vehicle> vehicles = new ArrayList<>();
		Vehicle v1 = Vehicle.getVehicle();
		Vehicle v2 = Vehicle.getVehicle();
		vehicles.add(v1);
		vehicles.add(v2);
		p1.setVehicles(vehicles);

		// add plot list
		List<Plot> plots = new ArrayList<>();
		Plot pl1 = Plot.getPlot();
		Plot pl2 = Plot.getPlot();
		plots.add(pl1);
		plots.add(pl2);
		p1.setPlots(plots);

		session.beginTransaction();
		session.persist(p1);
/*		session.save(v1);
		session.save(v2);
		session.save(pl1);
		session.save(pl2);
*/		session.getTransaction().commit();
		session.close();

	}

	/**
	 * To save vehicle entity automatically when person p1 is saved. We can use
	 * persist method for saving p1 and v1 will be saved automatically, if we
	 * are using cascade={CascadeType.PERSIST} in @OneToOne
	 */
}
