package kr.co.hucloud.security.code.example.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public String viewErrorPage(RuntimeException e) {
		return "errors/500";
	}
	
}
