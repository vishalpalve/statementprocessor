/*
 * Created on Mar 14, 2021
 *
 * $Id: CodeTemplates.xml,v 1.1 2012/11/29 19:54:11 adets Exp $
 * 
 * Copyright 2021 InfoDesk, Inc. All rights reserved.
 */
package com.stmt.processor.response;

import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
public class BaseResponse {

	protected Integer code = Status.OK.getStatusCode();

	@XmlType(name = "Status")
	public enum ResponseStatus {
		SUCCESSFUL, DUPLICATE_REFERENCE, INCORRECT_END_BALANCE, DUPLICATE_REFERENCE_INCORRECT_END_BALANCE, BAD_REQUEST, INTERNAL_SERVER_ERROR
	}

	protected ResponseStatus status = ResponseStatus.SUCCESSFUL;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public ResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BaseResponse [code=" + code + ", status=" + status + "]";
	}
}
