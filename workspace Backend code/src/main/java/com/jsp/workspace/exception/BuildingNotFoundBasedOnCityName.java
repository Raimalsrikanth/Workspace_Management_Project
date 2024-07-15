package com.jsp.workspace.exception;

import lombok.Data;

@Data
public class BuildingNotFoundBasedOnCityName extends RuntimeException {

	private String message = "building not found based on city name";

	public BuildingNotFoundBasedOnCityName(String message) {
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
