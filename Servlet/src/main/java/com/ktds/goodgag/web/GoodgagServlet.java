package com.ktds.goodgag.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoodgagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GoodgagServlet() {}

	protected void doGet(HttpServletRequest request, 
						HttpServletResponse response) 
							throws ServletException, IOException {
		String path = "/WEB-INF/view/goodgag/list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, 
						HttpServletResponse response) 
						throws ServletException, IOException {
		doGet(request, response);
	}

}
