///*
// * Created on Apr 6, 2020
// *
// * $Id: CodeTemplates.xml,v 1.1 2012/11/29 19:54:11 adets Exp $
// * 
// * Copyright 2020 InfoDesk, Inc. All rights reserved.
// */
//package com.stmt.processor.exception;
//
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response.Status;
//import javax.ws.rs.ext.ExceptionMapper;
//import javax.ws.rs.ext.Provider;
//
//import org.springframework.stereotype.Component;
//
//import com.stmt.processor.response.BaseResponse;
//
///**
// * Maps Exception generated from Validation of the data in request of REST APIs, and generated relevant response with proper
// * exception message to put in response and BAD-REQUEST status.
// *
// */
//@Provider
//@Component
//@Produces(MediaType.APPLICATION_JSON)
//public class RESTValidationExceptionMapper implements ExceptionMapper<StatementProcessorException> {
//
//	@Override
//	public javax.ws.rs.core.Response toResponse(final StatementProcessorException exception) {
//		final BaseResponse errorResponse = new BaseResponse();
//		errorResponse.setCode(Status.BAD_REQUEST.getStatusCode());
//		errorResponse.setStatus(BaseResponse.ResponseStatus.BAD_REQUEST);
//		return javax.ws.rs.core.Response.status(errorResponse.getCode()).type(MediaType.APPLICATION_JSON).entity(errorResponse)
//				.build();
//	}
//}
