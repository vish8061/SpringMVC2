package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.lti.dao.CustomerRepository;
import com.lti.entity.Customer;
import com.lti.exception.LoginException;

//@Component
@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	SendMailService sendMailService;
	
	public void add(Customer customer) {
		
		customerRepository.addCustomer(customer);
		sendMailService.send(customer.getEmail(), "Successfully Registered", "Thankyou for Registering. Welcome rey ! ");
	}
	
	public List<Customer> fetchAll() {
		
		List<Customer> customers = customerRepository.fetchCustomer();
		
		return customers;
	}
	
	public Customer login(String email,String password) throws LoginException{
		
		try{
			Customer customer = customerRepository.fetch(email,password);
			return customer;
		}
		catch (Exception e) {
			throw new LoginException("Inavalid Customer Credentials",e);
		}
		
	}
}
