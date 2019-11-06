package com.dineshonjava.customerservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.dineshonjava.customerservice.domain.Account;

/**
 * @author Dinesh.Rajput
 *
 */
//@Service
//public class AccountServiceImpl implements AccountService {
//
////	@Autowired
////	//@LoadBalanced
////	RestTemplate restTemplate;
////
////	//@HystrixCommand(fallbackMethod = "defaultAccount")
////	public List<Account> findByCutomer(Integer customer) {
////		return restTemplate.getForObject("http://ACCOUNT-SERVICE/account/customer/{customer}", List.class, customer);
////	}
////
////	private List<Account> defaultAccount(Integer customer) {
////		List<Account> defaultList = new ArrayList<>();
////		defaultList.add(new Account(0000, 1.000, 0000, "UNKNOWN ACCOUNT TYPE", "UNK", "FALLBACK BANK"));
////        return defaultList;
////    }
//@GetMapping(value = "/account/customer/{customer}")
//List<Account> findByCutomer (@PathVariable("customer") Integer customer);
//}
