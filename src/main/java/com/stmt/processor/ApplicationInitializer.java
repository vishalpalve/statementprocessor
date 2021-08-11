package com.stmt.processor;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;

import org.springframework.stereotype.Component;

import io.swagger.v3.jaxrs2.integration.JaxrsOpenApiContextBuilder;
import io.swagger.v3.oas.integration.OpenApiConfigurationException;
import io.swagger.v3.oas.integration.SwaggerConfiguration;
import io.swagger.v3.oas.integration.api.OpenApiContext;
import io.swagger.v3.oas.models.OpenAPI;

@Component
public class ApplicationInitializer extends Application {

	@SuppressWarnings("rawtypes")
	public ApplicationInitializer(@Context ServletConfig servletConfig) {
		super();
		OpenAPI oas = new OpenAPI();
		try {
			Set<String> resource = new HashSet<>();
			resource.add("com.stmt.processor");
			SwaggerConfiguration oasConfig = new SwaggerConfiguration().openAPI(oas).prettyPrint(true).resourcePackages(resource);

			OpenApiContext oac = new JaxrsOpenApiContextBuilder().servletConfig(servletConfig).application(this)
					.openApiConfiguration(oasConfig).buildContext(true);
			oac.read();
		} catch (OpenApiConfigurationException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}