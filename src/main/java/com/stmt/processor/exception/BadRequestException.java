package com.stmt.processor.exception;

public class BadRequestException extends StatementProcessorException {

	private static final long serialVersionUID = -2670360947385165603L;

	public BadRequestException(String message) {
		super(400, message);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
