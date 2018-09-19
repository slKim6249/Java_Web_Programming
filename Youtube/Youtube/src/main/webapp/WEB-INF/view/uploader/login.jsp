<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/layout/layout_header.jsp" />

	<script type="text/javascript">
		$().ready(function() {
			$("#loginBtn").click(function() {
				$("#loginForm").attr({
					method: "post",
					action: "<c:url value='/uploader/login'/>"
				}).submit();
			});
		});
	</script>

	<div>
		<c:if test="${param.error eq '1' }">
			<article>
				<div class="error">
					ID 또는 Password가 맞지 않습니다.
				</div>
			</article>
		</c:if>
		<form id="loginForm">
			<div>
				<input type="text" id="uploaderId" name="uploaderId" placeholder="Uploader ID" />
			</div>
			<div>
				<input type="password" id="password" name="password" placeholder="Password" />
			</div>
			<div>
				<input type="button" id="loginBtn" value="Login" />
			</div>
		</form>
	</div>

<jsp:include page="/WEB-INF/view/common/layout/layout_footer.jsp" />