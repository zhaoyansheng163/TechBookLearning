/**
 * 
 */
package com.dineshonjava.customerservice.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * @author Dinesh.Rajput
 *
 */
@FeignClient(name="account-service")
public interface AccountService {

	@GetMapping(value = "/account/{customer}")
	String findByCutomer (@PathVariable("customer") Integer customer);
	
	/*@PutMapping(value = "/account/{accountId}", consumes = "application/json")
    Account update(@PathVariable("storeId") Integer accountId, Account account);
	
	@DeleteMapping(value = "/account/{accountId}")
	void delete(@PathVariable("accountId") Integer accountId);
	
	@PostMapping(value = "/account/customer/", consumes = "application/json")
    Account update(@RequestBody Account account);*/
	
	/*@RequestLine("GET /api/{key}")
	void get(@Param("key") String key);*/
}
