/**
 * 
 */
package com.mgr.service.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author govind.raju
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class RegistrationServer {

	/**
	 * Running the application using Spring Boot and inbuilt Servlet engine.
	 * 
	 * @param args was passed from callble statement
	 */
	public static void main(String[] args) {
		// making use of registration.properties or yml

		System.setProperty("spring.config.name", "registration-server");

		SpringApplication.run(RegistrationServer.class, args);

	}

}
