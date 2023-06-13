package com.tech.kj.model.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionToJsonMapper extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handleIllegalArgument(IllegalArgumentException ex,WebRequest request) {
		Map<String, String> responseMap = new HashMap<String, String>();
		responseMap.put("message", ex.getMessage());
		return handleExceptionInternal(ex, responseMap, 
		          new HttpHeaders(), HttpStatus.CONFLICT, request);
	}
}
