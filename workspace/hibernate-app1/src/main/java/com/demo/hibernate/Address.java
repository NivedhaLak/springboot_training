package com.demo.hibernate;

public class Address {
	private String doorNo;
	private String Street;
	private String pinNo;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String doorNo, String street, String pinNo) {
		this.doorNo = doorNo;
		Street = street;
		this.pinNo = pinNo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getPinNo() {
		return pinNo;
	}

	public void setPinNo(String pinNo) {
		this.pinNo = pinNo;
	}

}
