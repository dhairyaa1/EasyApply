package org.workspace.common.exceptionhandling;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.workspace.common.models.ApiResponse;

@ComponentScan("com.workspace")
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserFriendlyException.class)
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public ResponseEntity<ApiResponse<Object>> handleUserFriendlyExceptions(UserFriendlyException e)
	{
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ApiResponse<Object>(e.getMessage(), null));
	}
	
	
	@ExceptionHandler(Exception.class)
	@Order(Ordered.LOWEST_PRECEDENCE)
	public ResponseEntity<ApiResponse<Object>> handleExceptions(Exception e)
	{
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ApiResponse<Object>("An error occured. Please try again after sometime.", null));
	}
	
	
}
