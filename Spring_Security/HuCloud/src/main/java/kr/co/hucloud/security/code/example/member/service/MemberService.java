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
	
	// 사용자의 권한을 가져오는 메소드
	// admin인지 아닌지 확인하기 위해서
	public MemberVO getGrade(LoginVO loginVO);

	public List<MemberVO> getUserInfo(String parameter);
	
	public boolean isBlockUser(String userId);
	
	public boolean unblockUser(String userId);
	
	public boolean blockUser(String userId);
	
	// login 실패시 fail count 증가
	public boolean iscreaseLoginFailCount(String userId);
	
}
