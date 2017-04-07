package com.demo.spring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class DeleteClient {

	public static void main(String[] args) {
		RestTemplate template = new RestTemplate();

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/rest/delete")
				.queryParam("id", 3);
		template.delete(builder.build().toUri());;
				
		

	}

}
