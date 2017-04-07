package com.demo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test1");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Dept dept = (Dept) em.find(Dept.class, 20);
			Emp e1 = new Emp(200, "Ankit", "Hyderabad", 50000);
			Emp e2 = new Emp(201, "Shekhar", "bangalore", 52000);
			e1.setDept(dept);
			e2.setDept(dept);
			em.persist(e1);
			em.persist(e2);
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			emf.close();
		}
	}

}
