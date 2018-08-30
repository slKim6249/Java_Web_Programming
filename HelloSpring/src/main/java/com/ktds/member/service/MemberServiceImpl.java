package com.ktds.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ktds.member.biz.MemberBiz;
import com.ktds.member.dao.MemberDao;
import com.ktds.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	@Qualifier("memberDaoImplMyBatis")
	private MemberDao memberDao;
	
	@Autowired
	private MemberBiz memberBiz;
	
	@Override
	public boolean createNewMember(MemberVO memberVO) {
		return memberDao.insertNewMember(memberVO) > 0;
	}

	@Override
	public MemberVO readOneMember(MemberVO memberVO) {
		
		MemberVO loginMemberVO = memberDao.selectOneMember(memberVO);
		
		if ( loginMemberVO != null ) {
			
			this.memberBiz.updatePoint(memberVO.getEmail(), +2);
			
			int point = loginMemberVO.getPoint();
			point += 2;
			loginMemberVO.setPoint(point);
		}
		
		
		return loginMemberVO;
	}

}






