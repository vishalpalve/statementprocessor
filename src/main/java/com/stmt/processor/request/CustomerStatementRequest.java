/*
 * Created on Feb 21, 2021
 *
 * $Id: CodeTemplates.xml,v 1.1 2012/11/29 19:54:11 adets Exp $
 * 
 * Copyright 2021 InfoDesk, Inc. All rights reserved.
 */
package com.stmt.processor.request;

public class CustomerStatementRequest {

	private Integer transactionReference;

	private String accountNumber;

	private Long startBalance;

	private Long mutation;

	private String description;

	private Long endBalance;

	public Integer getTransactionReference() {
		return transactionReference;
	}

	public void setTransactionReference(Integer transactionReference) {
		this.transactionReference = transactionReference;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getStartBalance() {
		return startBalance;
	}

	public void setStartBalance(Long startBalance) {
		this.startBalance = startBalance;
	}

	public Long getMutation() {
		return mutation;
	}

	public void setMutation(Long mutation) {
		this.mutation = mutation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getEndBalance() {
		return endBalance;
	}

	public void setEndBalance(Long endBalance) {
		this.endBalance = endBalance;
	}

}
