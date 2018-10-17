/**
 * 
 */
package com.mgr.service.accounts;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.mgr.accounts.AccountRepository;
import com.mgr.accounts.AccountsConfiguration;

/**
 * @author govind.raju
 *         
 *         
 *         This is virtual micro service,registring with discovery server Eureka 
 *         
 *         Account related configuration is imported with AccountsConfiguretion  
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(AccountsConfiguration.class)
public class AccountServer {

	/**
	 * @param args
	 */
	@Autowired
	protected AccountRepository accountRepository;
	
	protected Logger logger = Logger.getLogger(AccountServer.class.getName());
	
	public static void main(String[] args) {
		// properties are picking up from account-server.yml or account-server.properties
		System.setProperty("spring.config.name", "account-server");
		
		SpringApplication.run(AccountServer.class, args);

	}

}
