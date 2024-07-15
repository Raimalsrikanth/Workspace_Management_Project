package com.jsp.workspace.exception;

import lombok.Data;

@Data
public class AdminIdNotFound extends RuntimeException{

	private String message = "id is not found";

	public AdminIdNotFound(String message) {
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
