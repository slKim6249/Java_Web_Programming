package kr.co.hucloud.security.code.example.member.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.co.hucloud.security.code.example.common.Session;
import kr.co.hucloud.security.code.example.common.util.SHA256Util;
import kr.co.hucloud.security.code.example.member.dao.MemberDAO;
import kr.co.hucloud.security.code.example.member.service.MemberService;
import kr.co.hucloud.security.code.example.member.vo.LoginVO;
import kr.co.hucloud.security.code.example.member.vo.MemberRegistryVO;
import kr.co.hucloud.security.code.example.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public void addMember(MemberRegistryVO memberVO) {
		// 8자리 이상의 salt를 만들어준다.
		String salt = SHA256Util.generateSalt();
		String password = this.getHashedPassword(salt, memberVO.getUserPassword());
		
		memberVO.setUserPassword(password);
		memberVO.setSalt(salt);
		
		memberDAO.addMember(memberVO);
	}
	
	private String getHashedPassword(String salt, String password) {
		return SHA256Util.getEncrypt(password, salt);
	}
	
	@Override
	public boolean login(HttpSession session, LoginVO loginVO) {
	
		 String salt = memberDAO.getSaltById(loginVO.getId()); // salt 가져오기
	     String password = this.getHashedPassword(salt, loginVO.getPassword()); // 암호화된 패스워드
	     
	     loginVO.setPassword(password); // 암호화된 패스워드 설정
	      
	     MemberVO memberVO = memberDAO.login(loginVO);
	      
	     if(memberVO != null) {
	         session.setAttribute(Session.MEMBER, memberVO);
	      }
	      
	      return memberVO != null;

	}
	
	@Override
	public boolean login(LoginVO loginVO) {
		
		 String salt = memberDAO.getSaltById(loginVO.getId()); // salt 가져오기
	     String password = this.getHashedPassword(salt, loginVO.getPassword()); // 암호화된 패스워드
	     
	     
	     loginVO.setPassword(password); // 암호화된 패스워드 설정
	      
	     MemberVO memberVO = memberDAO.login(loginVO);
	      
	     return memberVO != null;
	}
	
	@Override
	public List<MemberVO> getUserInfo(String parameter) {
		return memberDAO.getUserInfo(parameter);
	}

	@Override
	public boolean isBlockUser(String userId) {
		return memberDAO.isBlockUser(userId);
	}

	@Override
	public boolean unBlockUser(String userId) {
		return memberDAO.unBlockUser(userId);
	}

	@Override
	public boolean blockUser(String userId) {
		return memberDAO.blockUser(userId);
	}

	@Override
	public boolean increaseLoginFailCount(String userId) {
		return memberDAO.increaseLoginFailCount(userId);
	}

	@Override
	public MemberVO getGrade(LoginVO loginVO) {
		return memberDAO.login(loginVO);
	}
	
}
