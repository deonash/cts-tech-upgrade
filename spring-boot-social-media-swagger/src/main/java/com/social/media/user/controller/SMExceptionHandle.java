package com.social.media.user.controller;

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

@ControllerAdvice
@RestController
public class SMExceptionHandle extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions	(Exception e, WebRequest request	){
				
		SocialMediaException seException = new SocialMediaException(new Date(),e.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object>(seException,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException	(UserNotFoundException e, WebRequest request	){
				
		SocialMediaException seException = new SocialMediaException(new Date(),e.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object>(seException,HttpStatus.NOT_FOUND);
		
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		SocialMediaException seException = new SocialMediaException(new Date(),"Validation Failed",ex.getBindingResult().toString());
		return new ResponseEntity<Object>(seException,HttpStatus.NOT_FOUND);
	
	}


}
