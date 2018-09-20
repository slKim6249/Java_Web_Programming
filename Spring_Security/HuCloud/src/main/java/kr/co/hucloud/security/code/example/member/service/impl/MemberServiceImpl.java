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
		
		String salt = SHA256Util.generateSalt();
		// 암호화 되있는 password
		String password = this.getHashedPassword(salt, memberVO.getUserPassword());
		
		// membervo에 암호화 된 password를 넣기
		memberVO.setUserPassword(password);
		memberVO.setSalt(salt);
		
		memberDAO.addMember(memberVO);
	}
	
	
	private String getHashedPassword(String salt, String password){
		return SHA256Util.getEncrypt(password, salt);
	}
	
	@Override
	public boolean login(HttpSession session, LoginVO loginVO) {
		
		// 가지고 있는 salt를 db에서 가져옴
		String salt = memberDAO.getSaltById(loginVO.getId());
		String password = this.getHashedPassword(salt, loginVO.getPassword());
		
		// login시 입력받은 비밀번호를 암호화시켜서 다시 넣어줌
		loginVO.setPassword(password);
		
		MemberVO memberVO = memberDAO.login(loginVO);
		
		if(memberVO != null) {
			session.setAttribute(Session.MEMBER, memberVO);
		}
		
		return memberVO != null;
	}
	
	@Override
	public boolean login(LoginVO loginVO) {
		String salt = memberDAO.getSaltById(loginVO.getId());
		String password = this.getHashedPassword(salt, loginVO.getPassword());
		
		// login시 입력받은 비밀번호를 암호화시켜서 다시 넣어줌
		loginVO.setPassword(password);
		
		MemberVO memberVO = memberDAO.login(loginVO);
		
		return memberVO != null;
	}
	
	@Override
	public MemberVO getGrade(LoginVO loginVO) {
		return null;
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
	public boolean unblockUser(String userId) {
		return memberDAO.unblockUser(userId);
	}

	@Override
	public boolean blockUser(String userId) {
		return memberDAO.blockUser(userId);
	}

	@Override
	public boolean iscreaseLoginFailCount(String userId) {
		return memberDAO.iscreaseLoginFailCount(userId);
	}

	
	
}
