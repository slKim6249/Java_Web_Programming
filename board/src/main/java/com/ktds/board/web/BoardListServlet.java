package com.ktds.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.board.service.BoardService;
import com.ktds.board.service.BoardServiceImpl;
import com.ktds.board.vo.BoardVO;

public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private BoardService boardService;
	
    public BoardListServlet() {
    	boardService = new BoardServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setAttribute("name", "손동식");
		List<BoardVO> boardList = boardService.readAllBoards();
		
		String path = "/WEB-INF/view/board/list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		request.setAttribute("boardList", boardList);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
