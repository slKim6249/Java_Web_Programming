package com.ktds.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ktds.member.vo.MemberVO;

public class SessionInterceptor extends HandlerInterceptorAdapter { // Interceptor 사용
	
	@Override
	public boolean preHandle( 
				HttpServletRequest request
				, HttpServletResponse response
				, Object handler) // handler == Controller
			throws Exception {
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_USER_");
		
		if ( member == null ) { // session이 없을 시
			response.sendRedirect("/HelloSpring/member/login"); // login Page로 이동
			return false;
		}
		
		return true;
	}
	
}
