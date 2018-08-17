<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/board/write">
		<div>
			<input type="text" name="title" placeholder="제목을 입력하세요" value="${boardVO.title}" />
		</div>
		<div>
			<textarea name="content" placeholder="내용을 입력하세요">${boardVO.content}</textarea>
		</div>
		<div>
			<input type="text" name="writer" placeholder="작성자를 입력하세요" value="${boardVO.writer}" >
		</div>
		<div>
			<input type="submit" value="등록" />
		</div>
	</form>
</body>
</html>