package com.jsp.workspace.exception;

public class AdminNameNotFound extends RuntimeException{
	
	private String message = "id not found";

	
	public AdminNameNotFound(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
