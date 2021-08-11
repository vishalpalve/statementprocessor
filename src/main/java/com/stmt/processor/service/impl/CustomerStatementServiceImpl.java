/*
 * Created on Mar 7, 2021
 *
 * $Id: CodeTemplates.xml,v 1.1 2012/11/29 19:54:11 adets Exp $
 * 
 * Copyright 2021 InfoDesk, Inc. All rights reserved.
 */
package com.stmt.processor.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.stmt.processor.request.CustomerStatementRequest;
import com.stmt.processor.response.BaseResponse.ResponseStatus;
import com.stmt.processor.response.CustomerStatementResponse;

@Service
public class CustomerStatementServiceImpl implements CustomerStatementService {

	private static Logger LOG = LoggerFactory.getLogger(CustomerStatementServiceImpl.class);

	@Override
	public CustomerStatementResponse generate(final List<CustomerStatementRequest> request) {
		LOG.info("Request received to generate customer statements : " + request.size());
		CustomerStatementResponse response = validateRequestAndGenerateResponse(request);
		LOG.info("Request completed to generate customer statements : " + request.size());
		return response;
	}

	private CustomerStatementResponse validateRequestAndGenerateResponse(final List<CustomerStatementRequest> request) {
		final CustomerStatementResponse response = new CustomerStatementResponse();
		if (request == null) {
			response.setCode(400);
			response.setStatus(ResponseStatus.BAD_REQUEST);
		} else {
			Map<Integer, List<CustomerStatementRequest>> transactionWiseStatement = request.stream()
					.collect(Collectors.groupingBy(CustomerStatementRequest::getTransactionReference));
			for (Integer t : transactionWiseStatement.keySet()) {
				final List<CustomerStatementRequest> list = transactionWiseStatement.get(t);
				if (transactionWiseStatement.get(t).size() > 1) {// duplicate values of transaction ref
					response.setStatus(ResponseStatus.DUPLICATE_REFERENCE);
					for (CustomerStatementRequest l : list) {
						Long expectedBal = l.getStartBalance() + l.getMutation();
						if (expectedBal.longValue() != l.getEndBalance().longValue()) {
							response.setStatus(ResponseStatus.DUPLICATE_REFERENCE_INCORRECT_END_BALANCE);
						}
						response.getErrorRecords().put(t, l.getAccountNumber());
					}
				} else {// unique values
					CustomerStatementRequest customerStatementRequest = list.get(0);
					Long expectedBal = customerStatementRequest.getStartBalance() + customerStatementRequest.getMutation();
					if (expectedBal.longValue() != customerStatementRequest.getEndBalance().longValue()) {
						response.setStatus(ResponseStatus.INCORRECT_END_BALANCE);
						response.getErrorRecords().put(t, customerStatementRequest.getAccountNumber());
					}
				}
			}
		}

		return response;
	}

}
