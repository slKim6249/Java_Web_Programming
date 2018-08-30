package com.ktds.member.web;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.common.session.Session;
import com.ktds.member.service.MemberService;
import com.ktds.member.validator.MemberValidator;
import com.ktds.member.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@GetMapping("/member/logout")
	public String doMemberLogoutAction( HttpSession session ) {
		// Logout
		session.invalidate();
		return "redirect:/member/login";
	}
	
	@GetMapping("/member/regist")
	public String viewMemberRegistPage() {
		return "member/regist";
	}
	
	@PostMapping("/member/regist")
	public ModelAndView doMemberRegistAction(
			@Validated({MemberValidator.Regist.class}) @ModelAttribute MemberVO memberVO, Errors errors) {
		
		ModelAndView view = new ModelAndView("redirect:/member/login");
		
		if ( errors.hasErrors() ) {
			view.setViewName("member/regist");
			view.addObject("memberVO", memberVO);
			return view;
		}
		
		boolean isSuccess = memberService.createNewMember(memberVO);
		return view;
	}
	
	@GetMapping("/member/login")
	public String viewMemberLoginPage() {
		return "member/login";
	}
	
	@PostMapping("/member/login")
	public ModelAndView doMemberLoginAction(
				@Validated({MemberValidator.Login.class}) @ModelAttribute MemberVO memberVO
				, Errors errors
				, HttpSession session
			) {
		
		ModelAndView view = new ModelAndView("redirect:/board/list");
		
		if ( errors.hasErrors() ) {
			view.setViewName("member/login");
			view.addObject("memberVO", memberVO);
			return view;
		}
		
		MemberVO loginMemberVO = this.memberService.readOneMember(memberVO);
		session.setAttribute(Session.USER, loginMemberVO);
		
		return view;
	}
	
}








