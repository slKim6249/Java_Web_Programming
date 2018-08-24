package com.ktds.common.exceptions.handler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.ktds.common.exceptions.PolicyViolationException;

@ControllerAdvice // Controller와 동일한 역할 수행, 예외 발생시 예외만 처리
public class GlobalExceptionHandler {
	
	// NoHandlerFoundException 예외가 발생했을때 해당 메소드 처리
	@ExceptionHandler(NoHandlerFoundException.class)
	public String noHandlerFoundExceptionHandler() {
		return "errors/404";
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String RuntimeExceptionHandler( RuntimeException e )
			 throws UnsupportedEncodingException {
		e.printStackTrace(); // 어느 Error인지 볼 때만 잠시 사용.
		
		if ( e instanceof PolicyViolationException ) { // Type 확인
			PolicyViolationException pve = (PolicyViolationException) e; // Casting
			return "redirect:" 
			+ pve.getRedirect()
			+ "?message=" 
			+ URLEncoder.encode(pve.getMessage(), "UTF-8"); // UTF-8 처리, Add throw
		}
		
		return "errors/500";
	}
	
}
