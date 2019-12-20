package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lti.entity.Customer;
import com.lti.exception.LoginException;
import com.lti.service.CustomerService;

@Controller
@SessionAttributes("loggedInCustomer")// now this data will stored in the session using spring annotation.in modelmap data gets vanished as soon as we refesh the dashboard.jsp 
public class LoginController {
	
	@Autowired
	private CustomerService customerService;//hello
	
	@RequestMapping(path="/login.lti", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, 
			@RequestParam("password") String password,ModelMap model) {
		try {
			Customer customer = customerService.login(email, password);
			model.put("loggedInCustomer", customer);
			return "dashboard.jsp";
		} catch (LoginException e) {
			e.printStackTrace();
			return "login.jsp";
		}
	}
}
