package com.gordon.doc_repo.exception;

public class ApiException extends RuntimeException {
   
	public ApiException(String message) {
		super(message);
	}
	
	public ApiException() {
		super("An error Occured during entity creation");
	}
}
