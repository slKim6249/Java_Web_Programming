<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form 	method="post" 
			action="/HelloSpring/board/write"
			enctype="multipart/form-data">
		<div>
			<input type="text" name="subject" placeholder="제목을 입력하세요." />
		</div>
		<div>
			<textarea name="content" placeholder="내용을 입력하세요."></textarea>
		</div>
		<div>
			<input type="file" name="file" placeholder="파일을 선택하세요." />
		</div>
		<div>
			<input type="submit" value="등록" />
			<a href="/HelloSpring/board/list">목록</a>
		</div>
	</form>

</body>
</html>