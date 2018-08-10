package member.service;

import java.util.List;

import member.dao.MemberDao;
import member.vo.Member;

public class MemberService {

	private MemberDao memberDao;
	
	public MemberService() {
		this.memberDao = new MemberDao();
	}
	
	public List<Member> findAllMembers() {
		return this.memberDao.selectAllMember();
	}
	
	public Member findOneMember(String memberID) {
		return this.memberDao.selectOneMember(memberID);
	}
	
	public boolean registOneMember(Member member) {
		return this.memberDao.insertOneMember(member) > 0;
	}
}
