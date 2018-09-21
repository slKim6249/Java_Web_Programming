package com.ktds.youtube.common.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public String viewErrorPage(RuntimeException e) {
		e.printStackTrace();
		return "error/500";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String viewNotFoundPage(NoHandlerFoundException e) {
		return "error/404";
	}
}
