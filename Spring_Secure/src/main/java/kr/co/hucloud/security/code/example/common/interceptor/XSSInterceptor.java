package kr.co.hucloud.security.code.example.common.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.nhncorp.lucy.security.xss.XssFilter;

public class XSSInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 모든 Parameter를 가져와 XSS Filtering 수행
		Map<String, String[]> requestParams = request.getParameterMap(); // 모든 파라미터가져오기
		
		XssFilter filter = XssFilter.getInstance("lucy-xss-filter.xml"); 
		
		// Parameter 키 : Parameter 값 출력s
		requestParams.entrySet().stream().forEach( entry -> {
			// 모든 파라미터를 가지고와서 필터에 걸기
			entry.getValue()[0] = filter.doFilter(entry.getValue()[0]);
			
			System.out.println(entry.getKey());
			System.out.println(entry.getValue()[0]);
			System.out.println("======================================");
			
		});
		
		
		return true;
	}
	
}
