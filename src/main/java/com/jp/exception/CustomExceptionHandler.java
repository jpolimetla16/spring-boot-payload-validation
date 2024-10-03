package com.jp.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exe,HttpServletRequest request){
		ApiError apiError = new ApiError();
		apiError.setTimestamp(LocalDateTime.now());
		apiError.setStatus(HttpStatus.BAD_REQUEST.value());
		apiError.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
		apiError.setMessage("Error validating request");
		apiError.setPath(request.getRequestURI());
		Map<String,String> errors = new HashMap<>();
		exe.getBindingResult().getFieldErrors().stream()
				.forEach(error->{
				   errors.put(error.getField(),error.getDefaultMessage());
				});
		apiError.setValidationErrors(errors);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}
	
	
}
