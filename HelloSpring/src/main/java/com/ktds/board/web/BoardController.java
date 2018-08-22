package com.ktds.board.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	// doGet과 같은 역할
	// Spring 4.2 이하에서 사용
	// @RequestMapping(value="/write", method=RequestMethod.GET)
	// Spring 4.3 이상에서 사용
	@GetMapping("/write")
	public String viewBoardWritePage() {
		return "board/write";
	}
	
	@PostMapping("/write")
	public String viewBoardWriteAction(@ModelAttribute BoardVO boardVO ) {
		boolean isSuccess = this.boardService.createBoard(boardVO);
		return "redirect:/list";
		// 1줄로 하는법 - 삼항연산자, JVM이 if로 변환하기 때문에 느리다. 
//		return this.boardService.createBoard(boardVO) ? "redirect:/list" : "redirect:/write";
	}
	
	// http://localhost:8080/HelloSpring/board/detail?id=1
	@RequestMapping("/board/detail")
	public ModelAndView viewBoardDetailPage( @RequestParam int id ) {
		BoardVO boardVO = this.boardService.selectOneBoard(id);
		
		ModelAndView view = new ModelAndView("board/detail");
		view.addObject("boardVO", boardVO);
		return view;
	}
	
}
