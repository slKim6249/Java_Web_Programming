<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Member List Page</title>
	<style type="text/css">
		#wrapper {
			width: 900px;
		}
		#no-articles {
			padding: 15px;
		}
		.padded {
			padding: 15px;
		}
		#wrapper > #headerWrapper > div,
		#wrapper > .contentWrapper > div {
			padding: 15px;
		}
		.header {
			font-weight: bold;
			text-align: center;
		}
		.email {
			width: 75px;
		}
		.name {
			width: 125px;
		}
		.password {
			width: 70px;
		}
		.box {
			display: inline-block;
		}
	</style>
</head>
<body>
	<div id="wrapper">
		<div id="headerWrapper">
			<div class="email header box">Email Address</div>
			<div class="name header box">Member Name</div>
			<div class="password header box">Member Password</div>
		</div>
		<c:choose>
			<c:when test="${not empty memberVOList}">
				<c:forEach items="${memberVOList}" var="member">
					<div class="contentWrapper">
						<div class="number box">${member.email}</div> <!-- 
						 --><div class="name box">
						 		<a href="/HelloSpring/member/detail/${member.email}">
						 			${member.name}
						 		</a>
						 	</div> <!--
						 --><div class="password box">${member.password}</div>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<div id="no-articles">
					등록된 회원이 없습니다.
				</div>
			</c:otherwise>
		</c:choose>
		<div class="padded">
			<a href="/HelloSpring/member/regist">회원 가입하기</a>
		</div>
	</div>
	
</body>
</html>