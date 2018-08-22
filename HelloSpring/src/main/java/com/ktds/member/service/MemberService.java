package com.ktds.member.service;

import java.util.List;

import com.ktds.member.vo.MemberVO;

public interface MemberService {
	
	public boolean cretaMember(MemberVO memberVO);
	
	public boolean updateMember(MemberVO memberVO);
	
	public MemberVO readOneMember(String email);
	
	public boolean deleteOneMember(String email);
	
	public List<MemberVO> readAllMember();
	
}
