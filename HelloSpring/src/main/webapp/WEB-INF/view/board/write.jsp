<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Form</title>
</head>
<body>
	
	<form method="post" action="/HelloSpring/write">
		<div>
			<input type="text" name="subject" placeholder="제목을 입력하세요." />
		</div>
		<div>
			<input name="content" placeholder="내용을 입력하세요." />
		</div>
		<div>
			<input type="email" name="email" placeholder="E-Mail을 입력하세요." />
		</div>
		<div>
			<input type="submit" value="제출" />
		</div>
	</form>
	
</body>
</html>