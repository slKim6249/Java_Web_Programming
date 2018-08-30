<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Regist</title>
</head>
<body>
	
	<h1>회원 등록하기</h1>
	<form:form 	modelAttribute="memberVO" 
				method="post" 
				action="/HelloSpring/member/regist">
		<div class="errors">
			<ul>
				<li><form:errors path="email" /></li>
				<li><form:errors path="name" /></li>
				<li><form:errors path="password" /></li>
			</ul>
		</div>
		<div>
			<input type="email" name="email" id="email" placeholder="Email" value="${memberVO.email}"/>
		</div>
		<div>
			<input type="text" name="name" placeholder="Name" value="${memberVO.name}"/>
		</div>
		<div>
			<input type="password" name="password" placeholder="Password" />
		</div>
		<div>
			<input type="submit" value="등록" />
		</div>
	</form:form>
	
</body>
</html>