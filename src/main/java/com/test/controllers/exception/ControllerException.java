package com.test.controllers.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerException {
	 @ExceptionHandler(Exception.class)
	    public String exception(Exception e) {
	 
	        return "error";
	    }
}
