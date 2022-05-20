package com.sinensia.juegos04.presentation.controllers.exceptionshandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sinensia.juegos04.exceptions.AlreadyExistsException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(AlreadyExistsException.class)
	protected ResponseEntity<?> handle1(Exception e, WebRequest request){
		
		return handleExceptionInternal(e,e.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
		
	}
	
	@ExceptionHandler(RuntimeException.class)
	protected ResponseEntity<?> handle2(Exception e, WebRequest request){
			
		return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
}
