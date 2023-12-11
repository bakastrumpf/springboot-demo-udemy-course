package com.springframework.boot.restapis.rest;

public class StudentNotFoundException extends RuntimeException{

//	public StudentNotFoundException() {
//		super();
//	}
//
//	public StudentNotFoundException(String message, Throwable cause, boolean enableSuppression,
//			boolean writableStackTrace) {
//		super(message, cause, enableSuppression, writableStackTrace);
//	}

	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentNotFoundException(String message) {
		super(message);
	}

	public StudentNotFoundException(Throwable cause) {
		super(cause);
	}
	
	

}
