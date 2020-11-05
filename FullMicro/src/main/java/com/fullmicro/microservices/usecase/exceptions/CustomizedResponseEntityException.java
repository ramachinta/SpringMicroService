package com.fullmicro.microservices.usecase.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fullmicro.microservices.usecase.miscellaneous.UserNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		ExceptionDetails ed = new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(true));
		ResponseEntity<Object> re= new ResponseEntity<Object>(ed,HttpStatus.INTERNAL_SERVER_ERROR);
		return re;
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ExceptionDetails> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) throws Exception {
		ExceptionDetails ed = new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(true));
		ResponseEntity<ExceptionDetails> re= new ResponseEntity<ExceptionDetails>(ed,HttpStatus.NOT_FOUND);
		return re;
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(), "Validation fails",ex.getBindingResult().toString());
		return (new ResponseEntity(exceptionDetails, HttpStatus.BAD_REQUEST));
	}
	

}
