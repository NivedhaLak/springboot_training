package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class WriterApp {

	@Autowired
	@Qualifier("decoratedWriter")
	Writer writer;

	public void print(String message) {
		System.out.println(writer.write(message));
	}
}
