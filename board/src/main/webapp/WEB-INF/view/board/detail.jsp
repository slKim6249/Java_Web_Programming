<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${boardVO.title }</h1>
	<h3>
		${boardVO.writer } 
		<span>${boardVO.createDate }</span>
		<span>추천수 : ${boardVO.recommendCount }</span>
		<span>조회수 : ${boardVO.viewCount }</span>
	</h3>
	<p>
		${boardVO.content }
	</p>
	<hr>
	<a href="/board/update?boardId=${boardVO.boardId }">수정</a>
	<a href="/board/recommend?boardId=${boardVO.boardId }">추천</a>
	<a href="/board/delete?boardId=${boardVO.boardId }">삭제</a>
</body>
</html>