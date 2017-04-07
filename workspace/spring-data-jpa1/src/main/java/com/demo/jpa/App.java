package com.demo.jpa;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.jpa.repo.MyRepository;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx= new AnnotationConfigApplicationContext(Config.class);
		
		MyRepository repo=(MyRepository)ctx.getBean("myRepository");
		
		Iterable<Emp> empList=repo.findAll();
		Iterator<Emp> emps=empList.iterator();
		while(emps.hasNext()){
			Emp e= emps.next();
				System.out.println(e.getName()+" "+e.getCity());
		}
		
		List<Emp> emps1=repo.getAllEmp5000();
		
		for(Emp e:emps1){
			System.out.println(e.getName()+" "+e.getCity());
		}
	}
}
