package kr.co.hucloud.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import kr.co.hucloud.security.code.example.member.service.MemberService;

// spring이 만들어 놓은 클래스 구현 필요


public class User implements UserDetails{

	// 멤버변수 추가
	private String userId;
	private String userPassword;
	private String grade;
	private boolean isBlockAccount;
	private String token;
	
	
	//
	public User(String userId, String userPassword, String grade, boolean isBlockAccount, String token) {
		this.userId = userId;
		this.userPassword = userPassword;
		// 계정의 권한
		this.grade = grade;
		this.isBlockAccount = isBlockAccount;
		// 발급받은 token
		this.token = token;
	}

	
	// getter, setter


	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	
	public boolean isBlockAccount() {
		return isBlockAccount;
	}

	public void setBlockAccount(boolean isBlockAccount) {
		this.isBlockAccount = isBlockAccount;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		authorities.add( new SimpleGrantedAuthority(grade));
		
		if ( grade.equals("ROLE_ADMIN") ) {
			
			authorities.add( new SimpleGrantedAuthority("ROLE_USER"));
		}
		
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.userPassword;
	}

	@Override
	public String getUsername() {
		return this.userId;
	}

	
	// 마지막에 isBlockAccount을 추가해주는 이유
	
	
	// 계정이 잠기지 않았으면 true
	// 휴면 계정이냐?
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	// 계정이 잠겼는지
	@Override
	public boolean isAccountNonLocked() {
		return !isBlockAccount;
	}
	// 비밀번호 만료가 되었냐?
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	// 계정이 활성화 되있는지
	@Override
	public boolean isEnabled() {
		return true;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}
	
	

}
