package com.workspace.common.models;

public class ApiResponse<T> {

	
	private String errorMessage;
	private T response;

	public ApiResponse(String errorMessage, T response)
	{	
		this.errorMessage = errorMessage;
		this.response = response;
	}
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}
}
