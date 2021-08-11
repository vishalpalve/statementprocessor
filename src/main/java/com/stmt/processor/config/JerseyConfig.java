package com.stmt.processor.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.stmt.processor.service.impl.CustomerStatementServiceImpl;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;

@Configuration
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		registerClasses(CustomerStatementServiceImpl.class);
		register(CORSFilter.class);
		// register(RESTValidationExceptionMapper.class);
		register(OpenApiResource.class);
	}
}