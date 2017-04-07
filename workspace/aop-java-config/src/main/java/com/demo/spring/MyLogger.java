package com.demo.spring;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class MyLogger {

	Logger logger = Logger.getLogger("demo");
	
	@Pointcut(value="execution(* com.demo.spring.Concat.doConcat(..))")
	public void pcut(){}

	@Before("execution(* com.demo.spring.Concat.doConcat(..))")
	@Order(value=2)
	public void logBefore() {
		logger.info("Before doConcat method call....1");
	}
	@Before("execution(* com.demo.spring.Concat.doConcat(..))")
	@Order(value=1)
	public void logBefore1() {
		logger.info("Before doConcat method call....2");
	}
	@AfterReturning("execution(* com.demo.spring.Concat.doConcat(..))")
	public void logAfter() {
		logger.info("After doConcat method call....");
	}
}
