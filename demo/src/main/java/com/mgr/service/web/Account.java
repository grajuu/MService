/**
 * 
 */
package com.mgr.service.web;

import java.math.BigDecimal;

/**
 * @author govind.raju
 * 
 *  A DTO for WebAccount Service
 *
 */
public class Account {

	
	protected Long id;
	protected String number;
	protected String owner;
	protected BigDecimal balance;
	
	protected Account() {
		balance = BigDecimal.ZERO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
		this.balance.setScale(2,BigDecimal.ROUND_HALF_EVEN);
	}
	
	@Override
	public String toString() {
		return number + " [" + owner + "]: $" + balance;
	}
}
