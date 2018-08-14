package com.ktds.index.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IndexClass() {}

	protected void doGet(HttpServletRequest request, 
						HttpServletResponse response) 
								throws ServletException, IOException {
		String path = "/WEB-INF/view/index/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, 
						HttpServletResponse response) 
								throws ServletException, IOException {
		doGet(request, response);
	}

}
