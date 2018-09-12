<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
<script type="text/javascript">
	$().ready( function(){
		
		$('#upload').click(function() {
			
			// JQuery ������� Form Data ����
			// �Ȱ��� ���̶� ������ �Ǵ� ��ġ�� �޶�����.
			// Validation Check�� �ϱ� ���ؼ� Jquery�� ����.
			// input�� id�� Valid Check
			// �̻��� ������ return; ���� ����
			if( $('#video').val() == "" ) {
				alert("������ �Է��� �ּ���.")
				$('#video').focus()
				return;
			}
			else if ( $('#title').val() == "" ) {
				alert("������ �Է��� �ּ���.")
				$('#title').focus()
				return;
			}
			else if ( $('#uploaderId').val() == "" ) {
				alert("���δ��� �Է��� �ּ���.")
				$('#uploaderId').focus()
				return;
			}
			else if ( $('#poster').val() == "" ) {
				alert("�����͸� ���÷��� �ּ���.")
				$('#poster').focus()
				return;
			}
			// ��� ���� �̻��� ���ٸ� sumbit
			/* $('#videoUploadForm').attr({
				'method': 'post',
				'action': '/Youtube/video/create'
			}) 
			.submit() */
			$("#videoUploadForm").submit();
		})
		
	})
</script>

	<jsp:include page="/WEB-INF/view/common/layout/layout_header.jsp" /> <!-- �ش� ��ο� �ִ� ������ �� �κп� ä�� �ִ´�. -->
				
				<h1>Video Upload</h1>
				
				<form id="videoUploadForm" method="post" action="/Youtube/video/create" enctype="multipart/form-data" > 
					<div>
						<input type="file" id="video" name="video" accept=".mp4, .avi, .wmv, .mkv"/> <!-- accept�� Ȯ���ڸ� ���� �� �ִ�. -->
					</div>
					<div>
						<input type="text" id="title" name="title" />
					</div>
					<div>
						<input type="text" id="uploaderId" name="uploaderId" />
					</div>
					<div>
						<input type="file" id="poster" name="poster" accept=".jpg, .png, .jpeg" />
					</div>
					<div>
						<input type="button" id="upload" value="Upload" />
					</div>
				</form>
				
	<jsp:include page="/WEB-INF/view/common/layout/layout_footer.jsp" />
			