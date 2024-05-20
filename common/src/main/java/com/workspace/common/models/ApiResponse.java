package com.workspace.common.models;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
public class ApiResponse<T> {

	
	private String errorMessage;
	private T response;

	public ApiResponse(T response)
	{
		this.response = response;
	}

}
