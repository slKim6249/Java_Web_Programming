<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>

	<h1>회원 로그인 하기</h1>
	<form method="post" action="/HelloSpring/member/login">
		<div>
			<input type="email" name="email" placeholder="Email" />
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