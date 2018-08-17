package com.ktds.board.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardRecommendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardRecommendServlet() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardId = request.getParameter("boardId");
		System.out.println(boardId);
		String path = "/WEB-INF/view/board/detail.jsp";
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
