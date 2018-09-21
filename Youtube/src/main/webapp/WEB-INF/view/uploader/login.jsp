<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/layout/layout_header.jsp" />
<script type="text/javascript">
	$().ready(function(){
		$("#loginBtn").click(function(){
			if ( $("#id").val() == "" ) {
				alert("id를 입력하세요")
				$("#id").focus()
				return
			}
			if ( $("#password").val() == "" ) {
				alert("password를 입력하세요")
				$("#password").focus()
				return
			}
			

			
			$("#uploaderLoginForm").attr({
				"method": "post",
				"action": "/Youtube/uploader/login"
			}).submit()
			
		})
	})
</script>


	<c:if test="${param.error eq '1' }">
		<article>
			<div class="error">
				아이디 혹은 비밀번호가 다릅니다
			</div>
		</article>
	</c:if>
	<form id="uploaderLoginForm">
		<div>
			<input type="text" id="uploaderId" name="uploaderId" placeholder="Enter ID" />	
		</div>
		<div>
			<input type="password" id="password" name="password" placeholder="Enter Password" />	
		</div>
		<div>
			<input type="button" id="loginBtn" value="LOGIN">
		</div>
	</form>
	
<jsp:include page="/WEB-INF/view/common/layout/layout_footer.jsp" />