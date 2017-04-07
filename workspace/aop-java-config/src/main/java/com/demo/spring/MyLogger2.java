package com.demo.spring;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLogger2 {

	Logger logger = Logger.getLogger("demo");

	@Pointcut(value = "execution(* com.demo.spring.Concat.doConcat(..))")
	public void pcut() {
	}

	@Around("execution(* com.demo.spring.Concat.doConcat(..))")
	public Object log(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("Before doConcat method call....1");
		Object retVal = pjp.proceed();
		logger.info("After doConcat method call....1");
		return retVal;
	}

}
