package com.demo.hibernate;

public class Emp {
	private int empNo;
	private String ename;
	private String city;
	Address address;
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	private double salary;
	
	
	public Emp(int empNo, String ename, String city, double salary) {
		this.empNo = empNo;
		this.ename = ename;
		this.city = city;
		this.salary = salary;
	}

	public Emp() {
		// TODO Auto-generated constructor stub
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
