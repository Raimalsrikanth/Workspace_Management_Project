package com.jsp.workspace.exception;

import lombok.Data;

@Data
public class BuildingNotFoundBasedOnId extends RuntimeException {
	
	private String message = "building id is not found";

	public BuildingNotFoundBasedOnId(String message) {
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
