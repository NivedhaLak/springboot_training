package com.demo.spring;

import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.dao.CustDAO;

@RestController
public class CustomerResource {
	@Autowired
	CustDAO dao;
	static HashMap<String, Customer> customers = new HashMap<String, Customer>();

	public CustomerResource() {
		customers.put("1", new Customer("1", "Anmit", "Bangalore",
				"amit@gmail.com"));
		customers.put("2", new Customer("2", "Kirthi", "Bangalore",
				"k100@gmail.com"));
		customers.put("3", new Customer("3", "Charan", "Hyderabad",
				"chiru@gmail.com"));
		customers.put("4", new Customer("4", "Karan", "Chennai",
				"k200@gmail.com"));
		customers.put("5", new Customer("5", "Gopal", "Bangalore",
				"g200@gmail.com"));
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String saveCustomer(@RequestBody Customer c) {
		
		int resp = dao.save(c);
		if (resp > 0) {
			return "Customer saved succesfully";
		} else {
			return "Something gone wrong";
		}
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Customer getCustById(@PathVariable("id") String id) {
		if (customers.containsKey(id)) {
			return customers.get(id);
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/getall", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ListEntity getAllCustomers() {
		ListEntity entity = new ListEntity();
		entity.setCustomer(new ArrayList<Customer>(customers.values()));
		return entity;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.TEXT_PLAIN_VALUE)
	public String removeCustomer(@RequestParam("id") String custId) {
		if (customers.containsKey(custId)) {
			customers.remove(custId);
			return "Customer Removed";
		} else {

			return "Customer does not exist";
		}
	}
}
