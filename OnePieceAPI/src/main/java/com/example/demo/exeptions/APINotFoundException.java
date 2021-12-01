package com.example.demo.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No Character exists with no provided ID")
public class APINotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public APINotFoundException() {
		super();
	}


	public APINotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}


	public APINotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}


	public APINotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}


	public APINotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}

