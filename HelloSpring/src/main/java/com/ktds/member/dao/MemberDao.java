package com.ktds.member.dao;

import java.util.Map;

import com.ktds.member.vo.MemberVO;

public interface MemberDao {

	public int insertNewMember(MemberVO memberVO);
	
	public MemberVO selectOneMember(MemberVO memberVO);
	
	public int updatePoint(Map<String, Object> param);
	
}
