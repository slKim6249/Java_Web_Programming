<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/layout/layout_header.jsp" />

	<script type="text/javascript">
		$().ready(function() {
			$("#registBtn").click(function() {
				$("#registForm").attr({
					method: "post",
					action: "<c:url value='/uploader/regist'/>",
					enctype: "multipart/form-data"
				}).submit();
			});
		});
	</script>

	<div>
		<form id="registForm">
			<div>
				<input type="text" id="uploaderId" name="uploaderId" placeholder="Uploader ID" />
			</div>
			<div>
				<input type="password" id="password" name="password" placeholder="Password" />
			</div>
			<div>
				<input type="text" id="name" name="name" placeholder="Name" />
			</div>
			<div>
				<input type="file" id="file" name="file" placeholder="Choose your profile image file" />
			</div>
			<div>
				<input type="button" id="registBtn" value="Regist" />
			</div>
		</form>
	</div>

<jsp:include page="/WEB-INF/view/common/layout/layout_footer.jsp" />