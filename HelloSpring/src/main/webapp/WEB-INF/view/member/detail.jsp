<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Member Detail Page</title>
	<style type="text/css">
		.email{
			color: purple;
			font-size: 27px;
			font-weight: bold;
		}
	</style>
</head>
<body>
	
	<h1 class="email">
		${memberVO.email}
	</h1>
	<h2>${memberVO.name}</h2>
	<h2>${memberVO.password}</h2>
	
	<div>
		<a href="/HelloSpring/member/delete/${memberVO.email}">회원 삭제</a>
		<a href="/HelloSpring/member/list">목록으로 돌아가기</a>
	</div>
</body>
</html>