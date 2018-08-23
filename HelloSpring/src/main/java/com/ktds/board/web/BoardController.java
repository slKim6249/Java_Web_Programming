package com.ktds.board.web;

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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.board.service.BoardService;
import com.ktds.board.vo.BoardVO;
import com.ktds.member.vo.MemberVO;

@Controller
public class BoardController {
	
	@Autowired
	@Qualifier("boardServiceImpl")
	private BoardService boardService;
	
	@RequestMapping("/board/list")
	public ModelAndView viewBoardListPage() {
		List<BoardVO> boardVOList = this.boardService.readAllBoards();
		
		ModelAndView view = new ModelAndView("board/list");
		view.addObject("boardVOList", boardVOList);
		return view;
	}
	
	// doGet과 같은 역할
	// Spring 4.2 이하에서 사용
	// @RequestMapping(value="/write", method=RequestMethod.GET)
	// Spring 4.3 이상에서 사용
	@GetMapping("/board/write")
	public String viewBoardWritePage( @SessionAttribute(name="_USER_", required=false) MemberVO memberVO ) {
		
		if( memberVO == null ) {
			return "redirect:/member/login";
		}
		
		return "board/write";
	}
	
	@PostMapping("/board/write")
	public String viewBoardWriteAction(@ModelAttribute BoardVO boardVO,
										HttpSession session) {
//		boolean isSuccess = this.boardService.createBoard(boardVO);
		
		MemberVO loginMemberVO = (MemberVO) session.getAttribute("_USER_");
		String email = loginMemberVO.getEmail();
		boardVO.setEmail(email);
		
		return this.boardService.createBoard(boardVO) ? "redirect:/board/list" : "redirect:/board/write";
	}
	
	// http://localhost:8080/HelloSpring/board/detail/1
	@RequestMapping("/board/detail/{id}")
	public ModelAndView viewBoardDetailPage( @PathVariable int id ) {
		BoardVO boardVO = this.boardService.readOneBoard(id);
		
		ModelAndView view = new ModelAndView("board/detail");
		view.addObject("boardVO", boardVO);
		return view;
	}
	
	@RequestMapping("/board/delete/{id}")
	public String doBoardDeleteAction( @PathVariable int id ) {
		boolean isSuccess = this.boardService.deleteOneBoard(id);
		return "redirect:/board/list";
	}
	
}
