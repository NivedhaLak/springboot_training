package com.demo.spring.cloud.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Resource1 {
	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public String getMessage() {
		return "Eureka, found it!";
	}

}
