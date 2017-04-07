package com.demo.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main2 {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure();
		/* SessionFactory sf = cfg.buildSessionFactory(); */
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		SessionFactory sf = cfg.buildSessionFactory(registry);

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Address address= new Address("111", "Street 2", "500059");
			Emp e = new Emp(122, "Raju", "Hyderabad", 40000);
			
			e.setAddress(address);
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
