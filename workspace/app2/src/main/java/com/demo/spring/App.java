package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		WriterApp app=(WriterApp)ctx.getBean("writerApp");
		
		app.print("Do It...");
		

	}
}
