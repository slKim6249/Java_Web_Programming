package com.ktds.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.member.dao.MemberDao;
import com.ktds.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public boolean cretaMember(MemberVO memberVO) {
		System.out.println("Call BoardService.createMember();");
		return memberDao.insertMember(memberVO) > 0;
	}

	@Override
	public boolean updateMember(MemberVO memberVO) {
		return memberDao.updateMember(memberVO) > 0;
	}

	@Override
	public MemberVO readOneMember(String email) {
		return memberDao.selectOneMember(email);
	}

	@Override
	public boolean deleteOneMember(String email) {
		return memberDao.deleteOneMember(email) > 0;
	}

	@Override
	public List<MemberVO> readAllMember() {
		return memberDao.selectAllMembers();
	}
	
	
	
}
