package com.easyapply.common.exceptionhandling;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.easyapply.common.models.ApiResponse;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserFriendlyException.class)
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public ResponseEntity<ApiResponse<Object>> handleUserFriendlyExceptions(UserFriendlyException e)
	{
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ApiResponse<Object>(e.getMessage(), null));
	}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
			MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
	
	@ExceptionHandler(Exception.class)
	@Order(Ordered.LOWEST_PRECEDENCE)
	public ResponseEntity<ApiResponse<Object>> handleExceptions(Exception e)
	{
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ApiResponse<Object>("An error occured. Please try again after sometime.", null));
	}
	
	
}
