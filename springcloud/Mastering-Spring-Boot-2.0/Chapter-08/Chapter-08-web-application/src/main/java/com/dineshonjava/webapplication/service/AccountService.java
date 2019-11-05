/**
 * 
 */
package com.dineshonjava.webapplication.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dineshonjava.webapplication.domain.Account;

/**
 * @author Dinesh.Rajput
 *
 */
@FeignClient("customer-service")
public interface AccountService {
	
	@GetMapping(value = "/account/{customer}")
	String findByCutomer (@PathVariable("customer") Integer customer);
	
}
