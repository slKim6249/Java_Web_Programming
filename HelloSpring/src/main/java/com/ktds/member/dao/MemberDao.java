package com.ktds.member.dao;

import java.util.List;

import com.ktds.member.vo.MemberVO;

public interface MemberDao {
	
	public int insertMember(MemberVO memberVO);
	
	public int updateMember(MemberVO memberVO);
	
	// 사용자가 요청하는 Param
	public MemberVO selectOneMember( String email );
	
	public int deleteOneMember( String email );
	
	public List<MemberVO> selectAllMembers();
	
}
