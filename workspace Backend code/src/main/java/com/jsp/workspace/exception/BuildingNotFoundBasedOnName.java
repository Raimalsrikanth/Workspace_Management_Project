package com.jsp.workspace.exception;

import lombok.Data;

@Data
public class BuildingNotFoundBasedOnName extends RuntimeException {
	
	private String message = "Building name not found";

	public BuildingNotFoundBasedOnName(String message) {
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
