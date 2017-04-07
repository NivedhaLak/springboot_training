package com.demo.spring.client;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {
	@LoadBalanced //This is required to call the services by registered name. else you need to use absolute URI
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
