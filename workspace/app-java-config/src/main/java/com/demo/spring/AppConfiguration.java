package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = { "com.demo.spring" })
public class AppConfiguration {

	@Bean()
	@Scope(scopeName = "prototype")
	@Lazy(value = true)
	public DecoratedWriter decoratedWriter() {
		DecoratedWriter writer = new DecoratedWriter();
		return writer;
	}
}
