package com.ktds.member.service;

import java.util.List;

import com.ktds.member.vo.MemberVO;

public interface MemberService {
	
	public boolean createMember(MemberVO memberVO);
	
	public boolean updateMember(MemberVO memberVO);
	
	public MemberVO readOneMember(MemberVO memberVO);
	
	public boolean deleteOneMember(MemberVO memberVO);
	
	public List<MemberVO> readAllMember();
	
}
