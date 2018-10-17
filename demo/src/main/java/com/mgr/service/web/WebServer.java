/**
 * 
 */
package com.mgr.service.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;


/**
 * @author govind.raju
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false)
public class WebServer {

	/**
	 * @param args
	 */
	
	public static final String ACCOUNTS_SERVICE_URL = "http://ACCOUNTS-SERVICE";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("spring.config.name", "web-server");
		SpringApplication.run(WebServer.class, args);
	}
	
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public WebAccountsService accountsService() {
		return new WebAccountsService(ACCOUNTS_SERVICE_URL);
	}
	
	@Bean
	public WebAccountsController accountsController() {
		 return new WebAccountsController(accountsService());
		
	}
	
	

}
