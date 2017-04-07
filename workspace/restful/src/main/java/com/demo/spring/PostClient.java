package com.demo.spring;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PostClient {

	public static void main(String[] args) {
		RestTemplate template = new RestTemplate();

		/*
		 * UriComponentsBuilder builder = UriComponentsBuilder
		 * .fromHttpUrl("http://localhost:8080/rest/add") .queryParam("a",
		 * 20).queryParam("b", 30); ResponseEntity<String> resp =
		 * template.getForEntity(builder.build() .toUri(), String.class);
		 * System.out.println(resp.getBody());
		 */

		Customer c = new Customer("9", "Pappu", "Patna", "pappu@hotmail.com");
		HttpEntity<Customer> requestData = new HttpEntity<Customer>(c);

		ResponseEntity<String> response = template.exchange(
				"http://localhost:8080/rest/save", HttpMethod.POST,
				requestData, String.class);

		System.out.println(response.getBody());
	}

}
