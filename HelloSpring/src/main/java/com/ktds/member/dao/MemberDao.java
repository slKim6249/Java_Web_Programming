package com.ktds.member.dao;

import java.util.List;

import com.ktds.member.vo.MemberVO;

public interface MemberDao {
	
	public int insertMember(MemberVO memberVO);
	
	public int updateMember(MemberVO memberVO);
	
	// 사용자가 요청하는 Param
	public MemberVO selectOneMember( MemberVO memberVO );
	
	public int deleteOneMember( MemberVO memberVO );
	
	public List<MemberVO> selectAllMembers();
	
}
