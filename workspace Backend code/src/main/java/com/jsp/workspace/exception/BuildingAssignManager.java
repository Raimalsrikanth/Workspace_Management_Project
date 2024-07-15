package com.jsp.workspace.exception;

import lombok.Data;

@Data
public class BuildingAssignManager extends RuntimeException {
	
	private String message = "Manager Already Assigned";

	public BuildingAssignManager(String message) {
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
