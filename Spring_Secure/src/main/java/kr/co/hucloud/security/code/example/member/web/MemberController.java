package kr.co.hucloud.security.code.example.member.web;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.hucloud.security.code.example.common.Session;
import kr.co.hucloud.security.code.example.common.util.SendMessage;
import kr.co.hucloud.security.code.example.member.service.MemberService;
import kr.co.hucloud.security.code.example.member.vo.LoginVO;
import kr.co.hucloud.security.code.example.member.vo.MemberRegistryVO;

@Controller
public class MemberController {

   private MemberService memberService;

   public void setMemberService(MemberService memberService) {
      this.memberService = memberService;
   }

   @RequestMapping(value=("/member/login"), method=RequestMethod.POST )
      public void login(LoginVO loginVO, HttpSession session, HttpServletResponse response) {
         
         boolean isBlockAccount = memberService.isBlockUser(loginVO.getId());
         boolean isLoginSuccess = false;
         // 로그인 횟수 제한 방어코드 작성
         if ( !isBlockAccount ){
            isLoginSuccess = memberService.login(session, loginVO);
            if ( !isLoginSuccess ){
               memberService.increaseLoginFailCount(loginVO.getId());
            }
            else {
               memberService.unBlockUser(loginVO.getId());
            }
         }
         else {
            SendMessage.send(response, "BLOCK_ACCOUNT");
            return;
         }
         
         // Token 값 생성 및 등록 코드 작성
         if( isLoginSuccess ) {
        	 String token = UUID.randomUUID().toString(); // Random 값
        	 session.setAttribute(Session.CSRF_TOKEN, token);
         }
         
         //이후 게시판 글 쓰기 페이지에서 Token 값 전달 받아 비교.
         SendMessage.send(response, isLoginSuccess ? "OK" : "NO");
      }
   
   @RequestMapping(value=("/member/logout"), method=RequestMethod.POST )
   public void logout(HttpSession session, HttpServletResponse response) {
      session.invalidate();
      SendMessage.send(response, "OK");
   }
   
   @RequestMapping("/member/registry" )
   public void registryMember(MemberRegistryVO memberVO, HttpServletResponse response) {
      try {
         //FIXME 회원가입시 비밀번호 체크하기
         /*
          * 하나 이상의 알파벳을 포함해야 함
          * 하나 이상의 숫자를 포함해야 함
          * 하나 이상의 특수문자를 포함해야 함
          * 최소 8글자 이상 입력해야 함
          */
         
         String password = memberVO.getUserPassword();
         String passwordPolicy = "((?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*()]).{8,})";
         
         Pattern pattern = Pattern.compile(passwordPolicy);
         Matcher matcher = pattern.matcher(password);
         
         if ( !matcher.matches() ) {
            SendMessage.send(response, "PASS_POLICY_VIOLATION");
            return;
         }
         
         //FIXME 회원가입시 비밀번호를 SHA-256 으로 SALT 이용해 암호화 하기
         memberService.addMember(memberVO);
         SendMessage.send(response, "OK");
      }
      catch(RuntimeException re) {
         re.printStackTrace();
         SendMessage.send(response, memberVO.getUserId() + "은(는) 이미 등록된 아이디 입니다.");
      } 
   }
   
}