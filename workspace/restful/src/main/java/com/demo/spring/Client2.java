package com.demo.spring;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class Client2 {

	public static void main(String[] args) {
		RestTemplate template = new RestTemplate();

		UriComponentsBuilder builder = UriComponentsBuilder
				.fromHttpUrl("http://localhost:8080/rest/getall");
		ResponseEntity<ListEntity> resp = template.getForEntity(builder.build()
				.toUri(), ListEntity.class);
		List<Customer> custs = resp.getBody().getCustomer();
		for (Customer c : custs) {
			System.out.println(c.getCustId() + " " + c.getName() + " "
					+ c.getAddress());
		}

	}

}
