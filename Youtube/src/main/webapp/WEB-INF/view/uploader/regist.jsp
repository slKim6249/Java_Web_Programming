<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/view/common/layout/layout_header.jsp" />
<script type="text/javascript">
	$().ready(function(){
		$("#registBtn").click(function(){
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
			if ( $("#name").val() == "" ) {
				alert("name을 입력하세요")
				$("#name").focus()
				return
			}
			if ( $("#file").val() == "" ) {
				alert("사진을 입력하세요")
				$("#file").focus()
				return
			}
			$("#uploaderRegistForm").attr({
				"method": "post",
				"action": "/Youtube/uploader/regist",
				"enctype" : "multipart/form-data"
			}).submit()
			
		})
	})
</script>


	<form id="uploaderRegistForm">
		<div>
			<input type="text" id="uploaderId" name="uploaderId" placeholder="Enter ID" />	
		</div>
		<div>
			<input type="password" id="password" name="password" placeholder="Enter Password" />	
		</div>
		<div>
			<input type="text" id="name" name="name" placeholder="Enter Name" />	
		</div>
		<div>
			<input type="file" id="file" name="file" placeholder="Enter File" />	
		</div>
		<div>
			<input type="button" id="registBtn" value="REGIST">
		</div>
	</form>
	
<jsp:include page="/WEB-INF/view/common/layout/layout_footer.jsp" />