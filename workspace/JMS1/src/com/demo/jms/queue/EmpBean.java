package com.demo.jms.queue;

import java.io.Serializable;

public class EmpBean implements Serializable{
	private String empId;
	private String name;
	private String details;
	private String salary;

	
	public String getDetails() {
		return empId + " " + name + " " + salary;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

}
