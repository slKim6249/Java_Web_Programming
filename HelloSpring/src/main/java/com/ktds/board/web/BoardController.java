package com.ktds.board.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.board.service.BoardService;
import com.ktds.board.vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	@Qualifier("boardServiceImpl")
	private BoardService boardService;
	
	@RequestMapping("/list")
	public String viewBoardListPage() {
		return "board/list";
	}
	
	// Get이나 Post 2가지 방식 다 사용한다.
	@RequestMapping("/detail")
	public ModelAndView viewBoardDetailPage() {
		ModelAndView view = new ModelAndView("board/detail");
		view.addObject("message", "Hello Spring");
		view.addObject("name", "Spring Web MVC Framework");
		view.addObject("age", 100);
		view.addObject("isAgree", false);
		return view;
	}
	
	// doGet과 같은 역할
	// Spring 4.2 이하에서 사용
	// @RequestMapping(value="/write", method=RequestMethod.GET)
	// Spring 4.3 이상에서 사용
	@GetMapping("/write")
	public String viewBoardWritePage() {
		return "board/write";
	}
	
	@PostMapping("/write")
	public String viewBoardWriteAction(HttpServletRequest request) {
		
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String email = request.getParameter("email");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setSubject(subject);
		boardVO.setContent(content);
		boardVO.setEmail(email);
		
		boolean isSuccess = this.boardService.createBoard(boardVO);
		
		if( isSuccess ) {
			return "redirect:/list";
		}
		else {
			return "redirect:/write";
		}
		
	}
	
}
