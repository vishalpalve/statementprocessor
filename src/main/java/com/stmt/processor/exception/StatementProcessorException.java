package com.stmt.processor.exception;

public class StatementProcessorException extends RuntimeException {

	private static final long serialVersionUID = 4197413357762661722L;

	private Integer errorCode;

	public StatementProcessorException() {
		super();
	}

	public StatementProcessorException(final Integer errorCode, final String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public StatementProcessorException(String message, Exception e) {
		super(message, e);
	}

	public Integer getErrorCode() {
		return errorCode;
	}

}
