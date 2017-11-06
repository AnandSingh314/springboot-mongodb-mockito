package com.practice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice()
public class PageNotFoundException {

	public PageNotFoundException() {
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String handleRuntimeExceptio(Exception exception){
		return "{\"status\":\"error\", \"desc\":\"runtime error occured\"}";
	}

}
