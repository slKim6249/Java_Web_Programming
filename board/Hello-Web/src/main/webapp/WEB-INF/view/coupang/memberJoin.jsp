<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/Hello-Web/css/common.css" />
</head>
<body>
	<div id="wrapper">
		<div id="logo">
			<img src="http://localhost:8080/Hello-Web/coupang.png">
		</div>
		<div>
			<div class="formbox">
				<img src="http://localhost:8080/Hello-Web/email.PNG"><!-- 
			 --><input type="email" placeholder="아이디(이메일)" >
			</div>
			<div class="formbox">
				<img src="http://localhost:8080/Hello-Web/pass.PNG"><!-- 
			 --><input type="password" placeholder="비밀번호(영문 숫자 특수문자 2가지 이상 6~15자 이내)" 
					minlength="5" maxlength="15" >
			</div>
			<div class="formbox">
				<img src="http://localhost:8080/Hello-Web/passCk.PNG"><!-- 
			 --><input type="password" placeholder="비밀번호 확인"
					minlength="5" maxlength="15" >
			</div>
			<div class="formbox">
				<img src="http://localhost:8080/Hello-Web/name.PNG"><!-- 
			 --><input type="text" placeholder="이름" >
			</div>
			<div class="formbox">
				<img src="http://localhost:8080/Hello-Web/phone.PNG"><!-- 
			 --><input type="tel" placeholder="휴대폰 번호" >
			</div>
		</div>
		<div id="join">동의하고 가입하기</div>
		<div id="agreement">
			본인은 <span class="bold">만 14세 이상</span>이며, 
			<span class="underline">쿠팡 이용약관</span>, 
			<span class="underline">전자금융거래이용약관</span>,
			<span class="underline">개인정보 수집 및 이용</span>, 
			<span class="underline">개인정보 제공</span> 내용을 확인 하였으며, 
			<span class="bold">동의합니다.</span>
		</div>
		<div id="copyright">
			©Coupang Corp. All rights reserved.
		</div>
	</div>
	
	<!-- Naver Inline Block -->
	<div id="header">
		<div class="box left">
			<div class="box">뉴스 스탠드</div>
			<div class="box">전체 언론사</div>
			<div class="box">MY 뉴스</div>
		</div>  
		<div class="box right">
			<div class="box">▦</div>
			<div class="box">▤</div>
			<div class="box">※</div>
			<div class="box">&lt;</div> <!-- less than -->
			<div class="box">&gt;</div> <!-- greater than -->
		</div>
	</div>
	<h1>Coupang</h1>
</body>
</html>