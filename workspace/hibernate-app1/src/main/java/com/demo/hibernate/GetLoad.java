package com.demo.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class GetLoad {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure();
		/* SessionFactory sf = cfg.buildSessionFactory(); */
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		SessionFactory sf = cfg.buildSessionFactory(registry);

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Emp e=(Emp)session.get(Emp.class, 121);
			Emp e1=(Emp)session.get(Emp.class, 121);
			
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sf.close();
		}

	}

}
