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
</head>
<body>
	<h2 style="text-align: center">회원 등록하기<span class="badge badge-primary">New</span></h2>
	<form method="post" action="/HelloSpring/member/regist">
		<div class="form-group">
			<label for="em">E-mail:</label>
			<input type="email" class="form-control" name="email" placeholder="E-mail을 입력하세요." id="em" />
		</div>
		<div class="form-group">
			<label for="usr">Name:</label>
			<input type="text" class="form-control" name="name" placeholder="아이디를 입력하세요." id="usr"/>
		</div>
		<div class="form-group">
			<label for="pwd">Password:</label>
			<input type="password" class="form-control" name="password" placeholder="비밀번호를 입력하세요." id="pwd" />
		</div>
		<div>
			<input type="submit" class="btn btn-info" value="제출" />
		</div>
	</form>
</body>
</html>