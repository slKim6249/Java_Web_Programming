package kr.co.hucloud.security.code.example.member.dao;

import java.util.List;

import kr.co.hucloud.security.code.example.member.vo.LoginVO;
import kr.co.hucloud.security.code.example.member.vo.MemberRegistryVO;
import kr.co.hucloud.security.code.example.member.vo.MemberVO;

public interface MemberDAO {

	public void addMember(MemberRegistryVO memberVO);

	public MemberVO login(LoginVO loginVO);

	public List<MemberVO> getUserInfo(String parameter);

	public List<MemberVO> getAllMemberInfo();

	public void updateMemberPassword(MemberVO member);

	public String getSaltById(String id);
	
	public boolean isBlockUser(String userId);
	
	public boolean unblockUser(String userId);
	
	public boolean blockUser(String userId);
	
	// login 실패시 fail count 증가
	public boolean iscreaseLoginFailCount(String userId);
}
