package com.demo.spring;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//@XmlRootElement
@XmlType
public class Customer {
	private String custId;
	private String name;
	private String address;
	private String email;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String custId, String name, String address, String email) {
		super();
		this.custId = custId;
		this.name = name;
		this.address = address;
		this.email = email;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
