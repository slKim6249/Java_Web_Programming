package kr.co.hucloud.security;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import kr.co.hucloud.security.code.example.common.Session;
import kr.co.hucloud.security.code.example.common.util.SendMessage;
import kr.co.hucloud.security.code.example.member.service.MemberService;
import kr.co.hucloud.security.code.example.member.vo.LoginVO;

public class UserService implements AuthenticationProvider{

	public MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// 기존 로그인 코드 작성
		
		String userId = authentication.getPrincipal().toString();
		String userPassword = authentication.getCredentials().toString();
		
        LoginVO loginVO = new LoginVO();
        loginVO.setId(userId);
        loginVO.setPassword(userPassword);
        
        
        boolean isBlockAccount = memberService.isBlockUser(loginVO.getId());
        boolean isLoginSuccess = false;
        
        // 로그인 횟수 제한 방어코드 작성
        if ( !isBlockAccount ){
            isLoginSuccess = memberService.login(loginVO);
            //System.out.println(isLoginSuccess);
           if ( !isLoginSuccess ){
              memberService.increaseLoginFailCount(loginVO.getId());
           }
           else {
              memberService.unBlockUser(loginVO.getId());
           }
        }
        
        UsernamePasswordAuthenticationToken result = null;
        
      // Token 값 생성 및 등록 코드 작성
        if ( isLoginSuccess) {
           String token = UUID.randomUUID().toString();
           String grade = "ROLE_USER";
           if ( userId.equals("admin")) {
        	   grade = "ROLE_ADMIN";
           }
           
           List<GrantedAuthority> roles = new ArrayList<>();
           roles.add(new SimpleGrantedAuthority(grade));
           
           if ( grade.equals("ROLE_ADMIN") ) {
        	   roles.add(new SimpleGrantedAuthority("ROLE_USER"));
           }
           
           result = new UsernamePasswordAuthenticationToken(userId, userPassword, roles);
           
           User user = new User(userId, userPassword, grade, isBlockAccount, token);
           result.setDetails(user);
        }
        else {
        	throw new BadCredentialsException("잘못된 인증");
        }
		
		return result;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
