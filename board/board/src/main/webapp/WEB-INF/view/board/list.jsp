<%@page import="com.ktds.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
List Page ${name} // EL(Extended Language) // JSTL
	<div>
		<span>${boardList.get(0).getBoardId() }</span> / 
		<span>
			<a href="/board/detail?boardId=${boardList.get(0).getBoardId()}">
				${boardList.get(0).getTitle() }
			</a>
		</span> / 
		<span>${boardList.get(0).getWriter() }</span> / 
		<span>${boardList.get(0).getCreateDate() }</span> / 
		<span>${boardList.get(0).getViewCount() }</span> / 
		<span>${boardList.get(0).getRecommendCount() }</span>
	</div>
</body>
</html>