package com.demo.spring;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestService {

	@RequestMapping(path = "/greet/{name}", method = RequestMethod.GET)
	public String greet(@PathVariable("name") String name) {
		return name + " Welcome to Spring REST Services";
	}

	@RequestMapping(path = "/message", method = RequestMethod.GET)
	public String getMessage(@RequestParam(value = "name", required = false) String name) {
		return "Hi," + name;
	}

	@RequestMapping(path = "/emp", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Emp getEmp() {
		Emp e = new Emp(100, "Shantanu", "Hyderabad", 30000);
		return e;
	}
}
