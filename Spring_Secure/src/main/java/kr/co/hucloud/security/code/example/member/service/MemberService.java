package kr.co.hucloud.security.code.example.member.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.co.hucloud.security.code.example.member.vo.LoginVO;
import kr.co.hucloud.security.code.example.member.vo.MemberRegistryVO;
import kr.co.hucloud.security.code.example.member.vo.MemberVO;

public interface MemberService {

	public void addMember(MemberRegistryVO memberVO);

	public boolean login(HttpSession session, LoginVO loginVO);
	public boolean login(LoginVO loginVO);
	public MemberVO getGrade(LoginVO loginVO); // 사용자의 권한

	public List<MemberVO> getUserInfo(String parameter);
	
	
	// Login 시도 횟수 제한 Interface
	public boolean isBlockUser(String userId);
	
	public boolean unBlockUser(String userId);
	
	public boolean blockUser(String userId);
	
	public boolean increaseLoginFailCount(String userId);
	
}
