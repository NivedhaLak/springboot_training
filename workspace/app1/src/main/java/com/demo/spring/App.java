package com.demo.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		
		//BeanFactory ctx1= new XmlBeanFactory(new FileSystemResource(path))
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");

		Mail mail = (Mail) ctx.getBean("mail");
		
		System.out.println(mail.getMessage().getBody());
		
		Mail mail1 = (Mail) ctx.getBean("mail");
		
		System.out.println(mail.hashCode()==mail1.hashCode());
		
		List<String> myList=(List<String>)ctx.getBean("list");
		System.out.println(myList);
		
	}
}
