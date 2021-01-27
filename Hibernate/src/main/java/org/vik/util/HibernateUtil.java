package org.vik.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static {
		try { 
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch( Exception ex ) {
			System.err.println("Initial SessionFactory creation failed."+ex);
			System.out.println("=====================================");
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
