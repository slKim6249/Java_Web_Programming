<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/HelloSpring/css/layout.css">
	<title>List Page</title>
	<script type="text/javascript">
		var message = "${param.message}";
		if( message != "" ) {
			alert(message);
		}
	</script>
</head>
<body>
	<div id="wrapper">
		<div id="headerWrapper">
			<div class="number header box">글 번호</div> <!-- 
			 --><div class="subject header box">제목</div> <!--
			 --><div class="writer header box">작성자</div> <!--
			 --><div class="create-date header box">작성일</div>
		</div>
		<c:choose>
			<c:when test="${not empty boardVOList}"> <!-- 비어 있지않을때 동작 -->
				<c:forEach items="${boardVOList}" var="board">
					<div class="contentWrapper">
						<div class="number box">${board.id}</div> <!-- 
						 --><div class="subject box">
						 		<a href="/HelloSpring/board/detail/${board.id}">
						 			${board.subject}
						 		</a>
						 	</div> <!--
						 --><div class="writer box">${board.memberVO.name}</div> <!--
						 --><div class="create-date box">${board.crtDt}</div>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise> <!-- 비어 있을 때 -->
				<div id="no-articles">
					등록된 게시물이 없습니다.
				</div>
			</c:otherwise>
		</c:choose>
		<div class="padded">
			<a href="/HelloSpring/board/write">게시글 작성하기</a>
		</div>
	</div>
</body>
</html>