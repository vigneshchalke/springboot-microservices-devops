package com.quiz.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 🔥 Validation Exception
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, Object> handleValidation(MethodArgumentNotValidException ex) {

	    Map<String, String> errors = new HashMap<>();

	    ex.getBindingResult().getFieldErrors().forEach(error -> {
	        errors.put(error.getField(), error.getDefaultMessage());
	    });

	    Map<String, Object> response = new HashMap<>();
	    response.put("status", "error");
	    response.put("message", "Validation failed");
	    response.put("errors", errors);

	    return response;
	}
	
	@ExceptionHandler(QuizNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Map<String, Object> handleQuizNotFound(QuizNotFoundException ex) {

	    Map<String, Object> response = new HashMap<>();
	    response.put("status", "error");
	    response.put("message", ex.getMessage());

	    return response;
	}
}