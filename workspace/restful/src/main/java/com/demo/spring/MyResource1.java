package com.demo.spring;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyResource1 {

	@RequestMapping(value = "/add", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String add(@RequestParam("a") int a, @RequestParam("b") int b) {
		int c = a + b;
		return c + "";
	}

	@RequestMapping(value = "/add/m", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String add2(@MatrixVariable("a") int a, @MatrixVariable("b") int b) {
		int c = a + b;
		return c + "";
	}

	@RequestMapping(value = "/add/{a}/{b}", method = RequestMethod.GET,produces=MediaType.TEXT_PLAIN_VALUE)
	public String add3(@PathVariable("a") int a, @PathVariable("b") int b) {
		int c = a + b;
		return c + "";
	}
}
