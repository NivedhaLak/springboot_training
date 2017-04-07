package clients;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class GetClient1 {

	public static void main(String[] args) {

		RestTemplate template = new RestTemplate();
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080").path("greet/Tiger");

		ResponseEntity<String> responseEntity = template.getForEntity(uriBuilder.build().toUri(), String.class);
		System.out.println(responseEntity.getBody());

	}

}
