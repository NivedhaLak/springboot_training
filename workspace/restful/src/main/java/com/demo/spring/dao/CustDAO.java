package com.demo.spring.dao;

import com.demo.spring.Customer;
import com.demo.spring.ListEntity;

public interface CustDAO {

	public int save(Customer c);

	public Customer getCust(int id);

	public ListEntity getAll();
	
	public void deleteCust(int id);
}
