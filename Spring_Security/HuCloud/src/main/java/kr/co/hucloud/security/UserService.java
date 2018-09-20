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

import kr.co.hucloud.security.code.example.member.service.MemberService;
import kr.co.hucloud.security.code.example.member.vo.LoginVO;

public class UserService implements AuthenticationProvider {

	public MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		System.out.println("유저 서비스 진입");
		// 기존 controller에 존재하던 login code
		
		String userId = authentication.getPrincipal().toString(); // 사용자가 입력한 id
		String userPassword = authentication.getCredentials().toString(); // 사용자가 입력한 password
		
		// 입력받은 값을 넣어줌.
		LoginVO loginVO = new LoginVO();
		loginVO.setId(userId);
		loginVO.setPassword(userPassword);
		
		boolean isBlockAccount = memberService.isBlockUser(loginVO.getId());
        
		System.out.println(isBlockAccount);
        boolean isLoginSuccess = false;
		
        // Session을 안쓰기 위해서 loginlogic 변경
		if ( !isBlockAccount ){
            isLoginSuccess = memberService.login(loginVO);
            
            System.out.println(isLoginSuccess);
            if ( !isLoginSuccess ){
               memberService.iscreaseLoginFailCount(loginVO.getId());
            }
            else {
               memberService.unblockUser(loginVO.getId());
            }
         }
         
         
         //boolean isLoginSuccess = memberService.login(session, loginVO);
         //FIXME 로그인 횟수 제한 방어코드 작성
         
		UsernamePasswordAuthenticationToken result = null;
         
         if ( isLoginSuccess) {
        	 String token = UUID.randomUUID().toString();
        	 String grade = "ROLE_USER";
        	 // login성공시 권한 부여
        	 // admin인지 아닌지 check
        	 if ( userId.equals("admin") ) {
        		 grade = "ROLE_ADMIN";
        	 }
        	 
        	 List<GrantedAuthority> roles = new ArrayList<>();
        	 roles.add(new SimpleGrantedAuthority(grade));
        	 
        	 // ADMIN이면 USER와 ADMIN의 권한을 가짐
        	 if ( grade.equals("ROLE_ADMIN") ) {
        		 roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        	 }
        	 
        	  result = new UsernamePasswordAuthenticationToken(userId
		  														, userPassword
		  														, roles);
        	 
        	 // 생성자를 통해 객체 만들어줌
        	 User user = new User(userId, userPassword, grade, isBlockAccount, token);
        	 System.out.println(user.getUsername());
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
