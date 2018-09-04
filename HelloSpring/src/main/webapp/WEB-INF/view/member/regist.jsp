<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Regist</title>
<script
      src="https://code.jquery.com/jquery-3.3.1.min.js"
      integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
      crossorigin="anonymous" ></script>
<script type="text/javascript">
	$().ready ( function(){
		$("#email").keyup( function() {
			
			// Ajax 요청
			/* $.post("URL", 요청 파라미터, function(response) {}) */
			$.post("/HelloSpring/member/check/duplicate"
					, {
						"email" : $(this).val() // #email		
					} 
					, function(response) {
						if( response.duplicate ){
							$("email-error").slideDown(200);
						}
						else {
							$("email-error").slideUp(200);
						}
					})
			
		})	
	})
</script>
</head>
<body>
	
	<h1>회원 등록하기</h1>
	<form:form 	modelAttribute="memberVO"
				autocomplete="off" 
				method="post" 
				action="/HelloSpring/member/regist">
		<div class="errors">
			<ul>
				<li><form:errors path="email" /></li>
				<li><form:errors path="name" /></li>
				<li><form:errors path="password" /></li>
			</ul>
		</div>
		<div>
			<input type="email" name="email" id="email" placeholder="Email" value="${memberVO.email}"/>
			<div id="email-error" style="display: none";>
				이 이메일은 사용할 수 없습니다.
			</div>
		</div>
		<div>
			<input type="text" name="name" placeholder="Name" value="${memberVO.name}"/>
		</div>
		<div>
			<input type="password" name="password" placeholder="Password" />
		</div>
		<div>
			<input type="submit" value="등록" />
		</div>
	</form:form>
	
</body>
</html>