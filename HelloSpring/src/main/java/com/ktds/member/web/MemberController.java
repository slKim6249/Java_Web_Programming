package com.ktds.member.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.member.service.MemberService;
import com.ktds.member.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	@Qualifier("memberServiceImpl")
	private MemberService memberService;
	
	@RequestMapping("/member/list")
	public ModelAndView viewMemberListPage() {
		List<MemberVO> memberVOList = this.memberService.readAllMember();
		
		ModelAndView view = new ModelAndView("member/list");
		view.addObject("memberVOList", memberVOList);
		return view;
	}
	
	@GetMapping("/member/regist")
	public String viewMemberRegistPage() {
		return "member/regist";
	}
	
	@PostMapping("/member/regist")
	public String doMemberRegistAction(@ModelAttribute MemberVO memberVO ) {
		boolean isSuccess = this.memberService.createMember(memberVO);
		return "redirect:/member/list";
	}
	
	@GetMapping("/member/login")
	public String viewMemberLoginPage() {
		return "member/login";
	}
	
	@PostMapping("/member/login")
	public String doMemberLoginAction(@ModelAttribute MemberVO memberVO,
										HttpSession session) {
		MemberVO loginMemberVO = this.memberService.readOneMember(memberVO);
		session.setAttribute("_USER_", loginMemberVO);
		
		return "redirect:/board/list";
	}
	
	// http://localhost:8080/HelloSpring/member/detail/{email}
//	@RequestMapping("/member/detail/{email}")
//	public ModelAndView viewMemberDetailPage( @PathVariable String email ) {
//		MemberVO memberVO = this.memberService.readOneMember(email);
//		
//		ModelAndView view = new ModelAndView("member/detail");
//		view.addObject("memberVO", memberVO);
//		return view;
//	}
//	
//	@RequestMapping("/member/delete/{email}")
//	public String doMemberDeleteAction( @PathVariable String email ) {
//		boolean isSuccess = this.memberService.deleteOneMember(email);
//		return "redirect:/member/list";
//	}
	
}