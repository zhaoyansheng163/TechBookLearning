package com.dineshonjava.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
//@EnableCircuitBreaker
//@EnableHystrixDashboard
public class CustomerServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

//	public static void main(String[] args) {
//		SpringApplication.run(CustomerServiceApplication.class, args);
//	}
//
//	@Bean
//	@LoadBalanced
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
}
