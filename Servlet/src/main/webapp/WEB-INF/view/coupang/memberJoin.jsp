<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/Servlet/css/common.css" />
</head>
<body>
	
	<!-- 전체를 감싸는 박스 -->
	<div id="wrapper">
		<!-- 쿠팡 로고를 넣어줄 박스 -->
		<div id="logo">
			<img src="http://localhost:8080/Servlet/coupang.png" />
		</div>
		<!-- 회원가입 폼을 감싸는 박스 -->
		<div>
			<!-- 아이디 입력폼을 감싸는 박스 -->
			<div class="form-box">
				<img src="http://localhost:8080/Servlet/email.png" /> <!-- inline block -->
				<input type="email" placeholder="아이디(이메일)" />
			</div>
			<!-- 비밀번호 입력폼을 감싸는 박스 -->
			<div class="form-box">
				<img src="http://localhost:8080/Servlet/password.png" /> 
				<input type="password" placeholder="비밀번호(영문 숫자 특수문자 2가지 이상 6~15자 이내)"
				 minlength="6" maxlength="15"/>
			</div>
			<!-- 비밀번호 입력폼을 감싸는 박스2 -->
			<div class="form-box">
				<img src="http://localhost:8080/Servlet/password2.png" /> 
				<input type="password" placeholder="비밀번호 확인" minlength="6" maxlength="20" />
			</div>
			<!-- 이름 입력폼을 감싸는 박스 -->
			<div class="form-box">
				<img src="http://localhost:8080/Servlet/name.png" /> 
				<input type="text" placeholder="이름" />
			</div>
			<!-- 휴대폰번호 입력폼을 감싸는 박스 -->
			<div class="form-box">
				<img src="http://localhost:8080/Servlet/phone.png" /> 
				<input type="tel" placeholder="휴대폰번호" />
			</div>
		</div>
		<!-- 동의하고 가입하기 버튼을 감싸는 박스 -->
		<div id="join">
			동의하고 가입하기
		</div>
		<!-- 약관 동의를 감싸는 박스 -->
		<div id="agreement">
			본인은 <span class="bold">만 14세 이상</span>이며,
			<span class="underline">쿠팡 이용약관</span>, 
			<span class="underline">전자금융거래이용약관</span>, 
			<span class="underline">개인정보 수집 및 이용</span>,
			<span class="underline">개인정보 제공</span> 내용을 확인 하였으며, 
			<span class="bold">동의합니다</span>.
		</div>
		<!-- 저작권 정보를 감싸는 박스 -->
		<div id="copyright">
			©Coupang Corp. All rights reserved.
		</div>
	</div>
	
</body>
</html>