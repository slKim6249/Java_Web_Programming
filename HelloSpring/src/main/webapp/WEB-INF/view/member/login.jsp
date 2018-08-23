<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert Form</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<style type="text/css">
	.regist {
		font-style: italic;
		color: red;
	}
	
	</style>
</head>
<body>
	<h2 style="text-align: center">회원 로그인 하기</h2>
	<form method="post" action="/HelloSpring/member/login">
		<div class="form-group">
			<label for="em">E-mail:</label>
			<input type="email" class="form-control" name="email" placeholder="E-mail을 입력하세요." id="em"/> <!-- _USER_ 의 session 정보를 가져온다. -->
		</div>
		<div class="form-group">
			<label for="pwd">Password:</label>
			<input type="password" class="form-control" name="password" placeholder="비밀번호를 입력하세요." id="pwd" />
		</div>
		<div>
			<input type="submit" class="btn btn-info" value="로그인" />
			<button type="button" class="btn btn-primary btn-md">
				<span class="regist"><a href="/HelloSpring/member/regist">회원 가입</a></span>
			</button>
		</div>
	</form>
</body>
</html>