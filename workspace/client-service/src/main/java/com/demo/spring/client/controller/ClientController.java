package com.demo.spring.client.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(name = "/call-service")
	public String getMessage() {
		String response = "no message";
		try {
			ResponseEntity<String> resp = restTemplate.getForEntity(new URI("http://emp-service/message"), String.class);
			response = resp.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}
