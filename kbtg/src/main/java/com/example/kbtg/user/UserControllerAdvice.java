package com.example.kbtg.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerAdvice {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> error_success(Exception e){
		ErrorResponse errorResponse = new ErrorResponse(1234 , e.getMessage());
		return new ResponseEntity<>(errorResponse , HttpStatus.OK);
	}
	
	
}
