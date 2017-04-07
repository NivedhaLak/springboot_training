package com.demo.spring;

import org.springframework.stereotype.Component;

@Component
public class PlainTextWriter implements Writer {

	@Override
	public String write(String s) {

		return "Plain Text Writer : " + s;
	}

}
