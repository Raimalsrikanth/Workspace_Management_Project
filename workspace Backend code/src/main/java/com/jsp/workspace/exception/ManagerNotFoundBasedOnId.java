package com.jsp.workspace.exception;

import lombok.Data;

@Data
public class ManagerNotFoundBasedOnId extends RuntimeException {
	
	private String message = "Manager id is not found";

	public ManagerNotFoundBasedOnId(String message) {
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
