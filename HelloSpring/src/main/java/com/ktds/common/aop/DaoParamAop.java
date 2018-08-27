package com.ktds.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaoParamAop {
	
	private Logger logger = LoggerFactory.getLogger(DaoParamAop.class);
	
	// Around Adviser
	// ProceedingJoinPoint -> 실행시키기 위한 포인트
	public Object getParam(ProceedingJoinPoint pjp) {
		
		// 어떤 클래스의 어떤 메소드를 사용하는지 확인한다.
		String classAndMethod = pjp.getSignature().toShortString();
		logger.debug(classAndMethod);
		
		// before
		// Parameter 가져오기
		Object[] paramArray = pjp.getArgs();
		
		for( Object param : paramArray ) {
			logger.debug(classAndMethod + " = " + param.toString());
		}
		
		// 기존의 메소드 실행
		Object result = null;
		try {
			// before, Business Logic
			// 메소드를 실행한다.
			result = pjp.proceed();
			// after-returning, Error 발생 없을 시, 결과
			logger.debug(classAndMethod + " = Result : " + result.toString());
		} catch (Throwable e) { // Error의 최상단 class - Throwable
			// after-throwing
			logger.debug(classAndMethod + " = Exception : " + e.getCause().toString() + " , " + e.getMessage());
			throw new RuntimeException(e.getMessage(), e);
		}
		
		return result;
		
	}
	
}
