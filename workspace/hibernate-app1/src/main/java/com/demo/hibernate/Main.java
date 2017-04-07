package com.demo.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure();
		/* SessionFactory sf = cfg.buildSessionFactory(); */
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		SessionFactory sf = cfg.buildSessionFactory(registry);

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Emp e = new Emp(121, "Manju", "Hyderabad", 40000);
			session.save(e);
			//session.flush();
			tx.commit();
			session.evict(e);

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sf.close();
		}

	}

}
