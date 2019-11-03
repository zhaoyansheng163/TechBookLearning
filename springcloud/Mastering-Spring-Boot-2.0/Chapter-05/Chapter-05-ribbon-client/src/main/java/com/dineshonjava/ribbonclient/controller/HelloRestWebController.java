/**
 * 
 */
package com.dineshonjava.ribbonclient.controller;

import com.dineshonjava.ribbonclient.service.HelloServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dinesh.Rajput
 *
 */
@RestController
public class HelloRestWebController {
	
	@Autowired
	HelloServiceClient helloServiceClient;
	
	@GetMapping("/rest/say-hello1")
	String sayHello1(ModelMap model){
		return "hello" + " retrun from ribbon client";
	}
}
