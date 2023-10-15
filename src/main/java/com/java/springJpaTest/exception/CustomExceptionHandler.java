package com.java.springJpaTest.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String,Object>> allResourceNotFoundException(Exception ex){
		
		Map<String, Object> errorMap = new HashMap<>();
		errorMap.put("timestamp", LocalDateTime.now());
		errorMap.put("title", "Exception in processing");
		errorMap.put("description", ex.getMessage());
		
		return new ResponseEntity<>(errorMap,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<CustomErrorResponse> allNullPointerException(NullPointerException ex){
		CustomErrorResponse error = new CustomErrorResponse();
		error.setTimestamp(LocalDateTime.now());
		error.setTitle("Exception in processing data");
		error.setDescription(ex.getMessage());
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
