<!-- <%@page import="com.ktds.board.vo.BoardVO"%>
<%@page import="java.util.List"%> -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
List Page ${name} // EL(Extended Language) // JSTL

<c:forEach items="${boardList}" var="board">
	<div>
		<span>${board.boardId}</span> / 
		<span>
			<a href="/board/detail?boardId=${board.boardId}">
				${board.title}
			</a>
		</span> / 
		<span>${board.writer}</span> / 
		<span>${board.createDate}</span> / 
		<span>${board.viewCount}</span> / 
		<span>${board.recommendCount}</span>
	</div>
</c:forEach>
<a href="/board/write">글쓰기</a>
</body>
</html>