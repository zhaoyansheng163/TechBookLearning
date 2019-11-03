/**
 * 
 */
package com.dineshonjava.ribbonclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * @author Dinesh.Rajput
 *
 */
@Service
public class HelloServiceClient {
	
	@Autowired
	@LoadBalanced
	RestTemplate restTemplate;


//	@Bean
//	@LoadBalanced
//	RestOperations restTemplate(RestTemplateBuilder builder) {
//		return builder.build();
//	}
//
//	@Autowired
//	RestOperations restTemplate;
	
	public String sayHello(){
		return restTemplate.getForObject("http://SPRING-CLOUD-EUREKA-CLIENT/hello", String.class);
	}
}
