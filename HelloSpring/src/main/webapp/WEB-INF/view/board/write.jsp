<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Write Board</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	<h2 style="text-align: center">게시판 작성하기<span class="badge badge-primary">New</span></h2>
	<form method="post" action="/HelloSpring/board/write">
		<div class="form-group">
			<label for="sub">제목:</label>
			<input type="text" class="form-control" name="subject" placeholder="제목을 입력하세요." id="sub" />
		</div>
		<div class="form-group">
			<label for="con">내용:</label>
			<input name="content" class="form-control" placeholder="내용을 입력하세요." id="con" />
		</div>
		<!-- <div class="form-group">
			<label for="em">E-Mail:</label>
			<input type="email" class="form-control" name="email" placeholder="E-Mail을 입력하세요." id="em"
					value="${sessionScope._USER_.email}" />
		</div>  -->
		<div class="form-group">
			<input type="submit" class="btn btn-info" value="제출" />
			<a href="/HelloSpring/board/list">목록으로 돌아가기</a>
		</div>
	</form>
	
</body>
</html>