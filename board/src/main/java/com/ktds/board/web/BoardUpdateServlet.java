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

public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardService boardService;   
	
    public BoardUpdateServlet() {
    	this.boardService = new BoardServiceImpl();
    }

	protected void doGet(HttpServletRequest request, 
						HttpServletResponse response) 
								throws ServletException, IOException {
		String boardId = request.getParameter("boardId");
		
		BoardVO boardVO = boardService.readOneBoard(boardId);
		request.setAttribute("boardVO", boardVO);
		
		String path = "/WEB-INF/view/board/update.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, 
						HttpServletResponse response) 
								throws ServletException, IOException {
		
		String boardId = request.getParameter("boardId");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBoardId(boardId);
		boardVO.setTitle(title);
		boardVO.setContent(content);
		
		boolean isSuccess = this.boardService.updateOneBoard(boardVO);
		
		if( isSuccess ) {
			response.sendRedirect("/board/detail?boardId=" + boardId);
		}
		else {
			response.sendRedirect("/board/update?boardId=" + boardId);
		}
	}

}
