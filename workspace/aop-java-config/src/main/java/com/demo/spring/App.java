package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		Object c = ctx.getBean("concat");
		System.out.println(c.getClass().getName());
		// System.out.println(c.doConcat("Shantanu", "Banerjee"));

	}

}
