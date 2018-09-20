package kr.co.hucloud.security.code.example.common.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.nhncorp.lucy.security.xss.XssFilter;

public class XssInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/*
		 * 모든 parameter를 가져와 XSS filtering 수행
		 * 
		 */
		
		Map<String, String[]> requestParams = request.getParameterMap();
		
		XssFilter filter = XssFilter.getInstance("lucy-xss-superset.xml");
		
		/*
		 * 파라미터 키 : 파라미터 값 출력
		 * 
		 * 어떤 값들이 있는지 체크하고 하나씩 고치기 위해
		 */
		
		
		
		requestParams.entrySet().stream().forEach(entry -> {
			entry.getValue()[0] = filter.doFilter(entry.getValue()[0]);

			System.out.println(entry.getKey());
			System.out.println(entry.getValue()[0]);
			System.out.println("===========================");
			
		});
		
		return true;
	}
}
