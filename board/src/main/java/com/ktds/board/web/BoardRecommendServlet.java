package com.ktds.board.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.board.service.BoardService;

public class BoardRecommendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService;
    
    public BoardRecommendServlet() { }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardId = request.getParameter("boardId");
		System.out.println("추천번호 " + boardId);
		
		boolean isSuccess = this.boardService.updateRecommendOneBoard(boardId);
		
		if ( isSuccess ) {
			response.sendRedirect("/board/detail?boardId=" + boardId);
		}
		else {
			response.sendRedirect("/board");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
