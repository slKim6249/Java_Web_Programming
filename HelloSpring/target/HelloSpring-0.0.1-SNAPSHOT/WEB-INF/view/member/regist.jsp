<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Regist</title>
</head>
<body>
	
	<h1>회원 등록하기</h1>
	<form method="post" action="/HelloSpring/member/regist">
		<div>
			<input type="email" name="email" id="email" placeholder="Email" />
		</div>
		<div>
			<input type="text" name="name" placeholder="Name"/>
		</div>
		<div>
			<input type="password" name="password" placeholder="Password"/>
		</div>
		<div>
			<input type="submit" value="등록" />
		</div>
	</form>
	
</body>
</html>