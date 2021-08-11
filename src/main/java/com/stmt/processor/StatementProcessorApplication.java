package com.stmt.processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StatementProcessorApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(StatementProcessorApplication.class, args);
	}
}
