package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Customer;

//@Component
@Repository
public class CustomerRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void addCustomer(Customer customer) {
		
		entityManager.merge(customer);
	}

	public List<Customer> fetchCustomer() {
		
		Query q = entityManager.createQuery("select c from Customer c");
		List<Customer> customers = q.getResultList();
		
		return customers;
	}
	
	public Customer fetch(String email, String password) {
			
		Query q = entityManager.createQuery("select c from Customer c where c.email= :em and c.password = :pw");
		q.setParameter("em", email);
		q.setParameter("pw", password);
		return (Customer) q.getSingleResult();
	}
}
