/**
 * 
 */
package com.mgr.accounts;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration;

/**
 * @author govind.raju This is {@link H2ConsoleAutoConfiguration} H2 relational
 *         Database.
 */
@Entity
@Table(name = "T_ACCOUNT")
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7215213075764920582L;
	public static Long nextId = 0L;

	@Id
	protected Long id;

	protected String number;

	@Column(name = "name")
	protected String owner;

	protected BigDecimal balance;

	/*
	 * Dont use the following logic for production use @GeneratedValue for squence
	 * generate ID's
	 * 
	 */

	protected static Long getNextId() {
		synchronized (nextId) {
			return nextId++;
		}

	}

	/*
	 * JPA Testing the service
	 */

	protected Account() {
		balance = BigDecimal.ZERO;
	}

	public Account(String number, String owner) {
		id = getNextId();
		this.number = number;
		this.owner = owner;
		balance = BigDecimal.ZERO;
	}

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public void setNumber(String accountNumber) {
		this.number = accountNumber;
	}

	public String getOwner() {
		return owner;
	}

	protected void setOwner(String owner) {
		this.owner = owner;
	}

	public BigDecimal getBalance() {
		return balance.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	public void withdraw(BigDecimal amount) {
		balance.subtract(amount);
	}

	public void deposit(BigDecimal amount) {
		balance.add(amount);
	}

	@Override
	public String toString() {
		return number + "[" + owner + "]: $" + balance;
	}
}
