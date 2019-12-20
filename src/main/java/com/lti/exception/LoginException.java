package com.lti.exception;

public class LoginException extends Exception {
	
	public LoginException(String msg,Throwable e) {
		super(msg,e);
	}

	public LoginException() {
		super();
	
	}

	public LoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	
	}

	public LoginException(String message) {
		super(message);
	
	}

	public LoginException(Throwable cause) {
		super(cause);
	
	}
	
	
}
