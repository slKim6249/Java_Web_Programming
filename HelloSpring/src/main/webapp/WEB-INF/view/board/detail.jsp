<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC</title>
</head>
<body>
	
	<h1>
		${boardVO.subject}
		<span style="font-size: 15px">${boardVO.crtDt}</span>
	</h1>
	<h2>${boardVO.email}</h2>
	
	<p>${boardVO.fileName}</p>
	
	<div>
		${boardVO.content}
	</div>
	
	<div>
		<a href="/HelloSpring/board/delete/${boardVO.id}">삭제</a>
		<a href="/HelloSpring/board/list">목록으로 돌아가기</a>
	</div>
	
</body>
</html>