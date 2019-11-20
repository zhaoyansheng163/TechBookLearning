package com.dineshonjava.accountservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import com.dineshonjava.accountservice.domain.Account;
import com.dineshonjava.accountservice.repository.AccountRepository;

/**
 * @author Dinesh.Rajput
 *
 */
@RestController
public class AccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	@Autowired
	private DiscoveryClient client;
	@Autowired
	AccountRepository accountRepository;
	
	@PostMapping(value = "/account")
	public Account save (@RequestBody Account account){
		logger.info("Saving Account information "+account);
		return accountRepository.save(account);
	}
	
	@GetMapping(value = "/account")
	public Iterable<Account> all (){
		logger.info("Find all accounts information ");
		return accountRepository.findAll();
	}
	
	@GetMapping(value = "/account/{accountId}")
	public Account findByAccountId (@PathVariable Integer accountId){
		Account account = accountRepository.findAccountByAccountId(accountId);
		logger.info("Find an Account information by account id: "+account);
		return account;
	}
	
	@PutMapping(value = "/account")
	public Account update (@RequestBody Account account){
		logger.info("Updating Account information "+account);
		return accountRepository.save(account);
	}
	
	@DeleteMapping(value = "/account")
	public void delete (@RequestBody Account account){
		logger.info("Deleting Account information "+account);
		accountRepository.delete(account);
	}
	
	@GetMapping(value = "/account/account-type/{type}")
	public List<Account> findByAccountType (@PathVariable String type){
		logger.info("Find all Accounts information by type: "+type);
		return accountRepository.findAllByAccountType(type);
	}
	
	@GetMapping(value = "/account/bank/{bank}")
	public List<Account> findByBank (@PathVariable String bank){
		logger.info("Find all Accounts information by bank: "+bank);
		return accountRepository.findByBank(bank);
	}
	
	@GetMapping(value = "/account/customer/{customer}")
	public List<Account> findByCutomer (@PathVariable Integer customer){
		logger.info("Find all Accounts information by customer: "+customer);
		return accountRepository.findAllByCustomerId(customer);
	}


	//服务发现机制
	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object discovery()
	{
		List<String> list = client.getServices();
		System.out.println("**********" + list);

		List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.client;
	}
}
