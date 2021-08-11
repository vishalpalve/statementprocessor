/*
 * Created on Feb 21, 2021
 *
 * $Id: CodeTemplates.xml,v 1.1 2012/11/29 19:54:11 adets Exp $
 * 
 * Copyright 2021 InfoDesk, Inc. All rights reserved.
 */
package com.stmt.processor.response;

import java.util.LinkedHashMap;
import java.util.Map;

public class CustomerStatementResponse extends BaseResponse {

	private Map<Integer, String> errorRecords = new LinkedHashMap<>();

	public CustomerStatementResponse() {
		super();
	}

	public Map<Integer, String> getErrorRecords() {
		return errorRecords;
	}

	public void setErrorRecords(Map<Integer, String> errorRecords) {
		this.errorRecords = errorRecords;
	}

	@Override
	public String toString() {
		return "CustomerStatementResponse [errorRecords=" + errorRecords + "]";
	}

}
