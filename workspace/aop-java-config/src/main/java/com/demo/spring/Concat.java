package com.demo.spring;

import org.springframework.stereotype.Component;

@Component
public class Concat {
	public String doConcat(String s1, String s2) {
		return s1 + " " + s2;
	}
}
