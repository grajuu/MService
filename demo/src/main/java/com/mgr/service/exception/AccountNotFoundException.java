/**
 * 
 */
package com.mgr.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author govind.raju
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AccountNotFoundException(String accountNumber) {
		super("No Such Account: "+accountNumber);
	}
	
	

}
