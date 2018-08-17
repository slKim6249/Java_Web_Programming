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

public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService;
       
    public BoardWriteServlet() {
        this.boardService = new BoardServiceImpl();
    }

	protected void doGet(HttpServletRequest request, 
						HttpServletResponse response) 
							throws ServletException, IOException {
		String path = "/WEB-INF/view/board/write.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, 
						HttpServletResponse response) 
							throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle(title);
		boardVO.setContent(content);
		boardVO.setWriter(writer);
		
		boolean isSuccess = boardService.createOneBoard(boardVO);
		
		if( isSuccess ) {
			response.sendRedirect("/board");
		}
		else {
			// response.sendRedirect("/board/write");
			
			request.setAttribute("boardVO", boardVO);
			
			String path = "/WEB-INF/view/board/write.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
		
	}

}
