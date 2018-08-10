package member.controller;

import java.util.List;

import member.service.MemberService;
import member.vo.Member;
import utils.Common;

public class MemberController {

	private MemberService memberService;
	
	public MemberController() {
		this.memberService = new MemberService();
	}
	
	public boolean registOneMember() {
		
		System.out.println("회원 가입 프로세스");
		
		System.out.print("등록할 회원 ID를 입력하세요 (20자 제한)");
		String memberID = Common.INPUT.next();
		
		System.out.print("회원의 비밀번호를 입력하세요.");
		String password = Common.INPUT.next();
		
		System.out.print("회원의 이름을 입력하세요.");
		String name = Common.INPUT.next();
		
		Member Member = new Member(memberID, password, name);
		
		return this.memberService.registOneMember(Member);
		
	}
	
	public void printAllMembers() {
		System.out.println("회원 전체 조회 목록");
		
		List<Member> MemberList = 
				this.memberService.findAllMembers();
		
		for (Member member : MemberList) {
			System.out.println("========================");
			System.out.println("회원의 아이디 : " + member.getMemberID());
			System.out.println("회원의 비밀번호 : " + member.getPassword());
			System.out.println("회원의 이름 : " + member.getName());
			System.out.println("회원의 등록 날짜 : " + member.getRegisteredDate());
		}
	}
	
	public void printOneMember() {
		System.out.println("회원 조회");
		
		System.out.println("찾으려는 회원의 ID를 입력하세요");
		String memberID = Common.INPUT.next();
		
		Member member = 
				this.memberService.findOneMember(memberID);
		
		try {
			System.out.println("========================");
			System.out.println("회원의 아이디 : " + member.getMemberID());
			System.out.println("회원의 비밀번호 : " + member.getPassword());
			System.out.println("회원의 이름 : " + member.getName());
			System.out.println("회원의 등록 날짜 : " + member.getRegisteredDate());
		} catch (NullPointerException e) {
			System.out.println("찾으려는 ID가 등록되어있지 않습니다.");
		}
		
	}
}
