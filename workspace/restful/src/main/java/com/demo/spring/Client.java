package com.demo.spring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class Client {

	public static void main(String[] args) {
		RestTemplate template = new RestTemplate();

		UriComponentsBuilder builder = UriComponentsBuilder
				.fromHttpUrl("http://localhost:8080/add")
				.queryParam("a", 20).queryParam("b", 30);
		
		ResponseEntity<String> resp = template.getForEntity(builder.build()
				.toUri(), String.class);
		
		System.out.println(resp.getBody());

	}

}
