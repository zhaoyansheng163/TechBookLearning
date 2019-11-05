package com.dineshonjava.customerservice.controller;

import com.dineshonjava.customerservice.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dineshonjava.customerservice.domain.Customer;
import com.dineshonjava.customerservice.repository.CustomerRepository;
import com.dineshonjava.customerservice.service.AccountService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dinesh.Rajput
 *
 */
@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AccountService accountService;  
	
	@PostMapping(value = "/customer")
	public Customer save (@RequestBody Customer customer){
		return customerRepository.save(customer);
	}
	
	@GetMapping(value = "/customer")
	public Iterable<Customer> all (){
		return customerRepository.findAll();
	}
	
	@GetMapping(value = "/account/{customerId}")
	public String findByAccountId (@PathVariable Integer customerId){
		Customer customer = new Customer();
		Account a = new Account();
		a.setAccountId(customerId);
		a.setBank("testbank");
		List<Account> l = new ArrayList<>();
		l.add(a);
		customer.setAccount(l);
		return "cuccc:" + customerId;
	}
	
	@PutMapping(value = "/customer")
	public Customer update (@RequestBody Customer customer){
		return customerRepository.save(customer);
	}
	
	@DeleteMapping(value = "/customer")
	public void delete (@RequestBody Customer customer){
		customerRepository.delete(customer);
	}
	
}
