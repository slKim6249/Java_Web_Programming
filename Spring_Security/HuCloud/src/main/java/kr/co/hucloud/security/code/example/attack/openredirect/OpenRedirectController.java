package kr.co.hucloud.security.code.example.attack.openredirect;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OpenRedirectController {

	@RequestMapping("/attack/openredirect")
	public String openRedirect(HttpServletResponse response) {
		return "attack/openredirect/openredirect";
	}
	
	@RequestMapping("/attack/openredirect/url")
	public ModelAndView redirect(HttpServletRequest request, HttpServletResponse response) {
		
		// Paros / WireShark / Internet Explorer 에서 변조 가능.
		
		// whiteList로 바꿔주는 작업이 필요
		Map<String, String> urlWhiteList = new HashMap<>();
		urlWhiteList.put("1", "http://naver.com");
		urlWhiteList.put("2", "http://daum.net");
		urlWhiteList.put("3", "http://google.com");
		
		// Redirect 값은 모두 상수로 변환하고
		// 서버에서 허용하는 URL값을 가지고 있어야 한다.
		String url = request.getParameter("redirectURL");
		
		// 여기서 url을 받아서 처리
		url = urlWhiteList.get(url);
		
		// isEmpty spring core에 있는 것
		// null이거나 비어있다면 url을 공백으로
		if(StringUtils.isEmpty(url)) {
			url = "";
		}
		return new ModelAndView("redirect:" + url);
	}
	
}
