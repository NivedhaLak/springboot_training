package com.demo.jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.jpa.Emp;

@Repository
public interface MyRepository extends CrudRepository<Emp, Integer> {

	@Query("select e from Emp e where e.salary>50000")
	public List<Emp> getAllEmp5000();
	
	//public String getNamenn();
}
