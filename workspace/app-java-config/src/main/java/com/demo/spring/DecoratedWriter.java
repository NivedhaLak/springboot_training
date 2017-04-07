package com.demo.spring;

import org.springframework.stereotype.Component;

//@Component
public class DecoratedWriter implements Writer {

	@Override
	public String write(String s) {

		return "Decorated Writer : " + s;
	}

}
