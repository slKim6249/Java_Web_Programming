<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <jsp:include page="/WEB-INF/view/common/layout/layout_header.jsp" />
    
<script type="text/javascript">
	$().ready(function() {
		$("#upload").click(function() {
			
			if ( $("#video").val() == "" ) {
				alert("비디오를 선택해 주세요.")
				$("#video").focus()
				return
			}			
			else if ( $("#title").val() == "" ) {
				alert("제목을 입력해 주세요.")
				$("#title").focus()
				return
			}
			else if ( $("#uploaderId").val() == "" ) {
				alert("업로더를 입력해 주세요.")
				$("#uploaderId").focus()
				return
			}
			else if ( $("#poster").val() == "" ) {
				alert("포스터를 선택해 주세요.")
				$("#poster").focus()
				return
			}
			
			/* $("#videoUploadForm").attr({
				"method": "post",
				"action": "/Youtube/video/create11"
			})
			.submit() */
			$("#videoUploadForm").submit()
			
		})
	})
</script>

	
	
				<h1>Video Upload</h1>
				
				<form id="videoUploadForm" method="post" action="/Youtube/video/create" enctype="multipart/form-data">
					<div>
						<input type="file" id="video" name="video" />
					</div>
					<div>
						<input type="text" id="title" name="title" />
					</div>
					<div>
						<input type="hidden" 
								id="uploaderId" 
								name="uploaderId" 
								value="${sessionScope._USER_.uploaderId}" />
					</div>
					<div>
						<input type="file" id="poster" name="poster" />
					</div>
					<div>
						<input type="button" id="upload" value="Upload" />
					</div>
				</form>
				
	<jsp:include page="/WEB-INF/view/common/layout/layout_footer.jsp" />
	
	
	
	
	
	
	