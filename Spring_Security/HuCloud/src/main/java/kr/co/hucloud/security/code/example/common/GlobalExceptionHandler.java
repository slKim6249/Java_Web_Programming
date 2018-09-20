package kr.co.hucloud.security.code.example.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	// 예전에는 autowired 이번에는 등록을 시켜줘야함. 
	
	@ExceptionHandler(RuntimeException.class)
	public String viewErrorPage(){
		
		return "errors/500";
	}
	
}
