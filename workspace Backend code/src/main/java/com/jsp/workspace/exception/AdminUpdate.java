package com.jsp.workspace.exception;

public class AdminUpdate {
	
	private String message = "Admin Not found";
	
	
	public AdminUpdate(String message) {
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
