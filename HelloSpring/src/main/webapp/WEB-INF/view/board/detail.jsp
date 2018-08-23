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
		제목 : ${boardVO.subject}
		<span style="font-size: 15px">작성 시간 : ${boardVO.crtDt}</span>
	</h1>
	<h2>작성자 : ${boardVO.memberVO.name}</h2>
	
	<p>파일이름 : ${boardVO.fileName}</p>
	
	<div>
		내용 : ${boardVO.content}
	</div>
	
	<div>
		<a href="/HelloSpring/board/delete/${boardVO.id}">삭제</a>
		<a href="/HelloSpring/board/list">목록으로 돌아가기</a>
	</div>
	
</body>
</html>