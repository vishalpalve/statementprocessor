package com.stmt.processor.service.impl;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.stmt.processor.request.CustomerStatementRequest;
import com.stmt.processor.response.CustomerStatementResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * Services that deals with customer statement
 * 
 */
@Path(value = "/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface CustomerStatementService {

	/**
	 * generates customer statement
	 * 
	 * @param request
	 * @return
	 */
	@POST
	@Tag(name = "Customer")
	@Operation(summary = "Generates customer statement.")
	CustomerStatementResponse generate(@Valid List<CustomerStatementRequest> request);
}
