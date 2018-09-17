<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Regist</title>
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
<script type="text/javascript">
	
	$().ready(function() {
		$('#regist').click(function() {
			if( $('#uploaderId').val() == "" ) {
				alert("���ε� ���̵� �Է��� �ּ���.")
				$('#uploaderId').focus()
				return;
			}
			else if ( $('#name').val() == "" ) {
				alert("�̸��� �Է��� �ּ���.")
				$('#name').focus()
				return;
			}
			else if ( $('#password').val() == "" ) {
				alert("��й�ȣ�� �Է��� �ּ���.")
				$('#password').focus()
				return;
			}
			else if ( $('#picturePath').val() == "" ) {
				alert("�̹����� ���÷��� �ּ���.")
				$('#picturePath').focus()
				return;
			}
			
			$('#registForm').attr({
				'method': 'post',
				'action': '/Youtube/uploader/regist'
			}) 
			.submit();
			// $("#registForm").submit();
		})
	})

</script>
</head>
<body>
	<form id="registForm">
		<div>
			<input type="text" id="uploaderId" name="uploaderId" placeholder="ID" />
		</div>
		<div>
			<input type="text" id="name" name="name" placeholder="Name" />
		</div>
		<div>
			<input type ="password" id="password" name="password" placeholder="Password" >
		</div>
		<div>
			<input type="file" id="picturePath" name="picturePath" accept=".jpg, .png, .jpeg, .gif"/>
		</div>
		<div>
			<input type="button" id="regist" value="Regist" />
		</div>
	</form>
</body>
</html>