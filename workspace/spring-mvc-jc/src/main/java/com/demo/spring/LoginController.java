package com.demo.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String getLoginPage() {
		return "login";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ModelAndView doLogin(@RequestParam("userName") String name, @RequestParam("password") String password) {
		ModelAndView mb = new ModelAndView();
		if (name.equals(password)) {
			mb.addObject("user", name);
			mb.setViewName("success");
			return mb;
		} else {
			mb.setViewName("failure");
			return mb;
		}
	}
}
