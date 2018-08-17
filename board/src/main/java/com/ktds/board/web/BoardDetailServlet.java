package com.ktds.board.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.board.service.BoardService;
import com.ktds.board.service.BoardServiceImpl;
import com.ktds.board.vo.BoardVO;

public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BoardService boardService;
	
    public BoardDetailServlet() {
    	this.boardService = new BoardServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		BoardVO boardVO = this.boardService.readOneBoard(request.getParameter("boardId"));
		request.setAttribute("boardVO", boardVO);
		
		String path = "/WEB-INF/view/board/detail.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
