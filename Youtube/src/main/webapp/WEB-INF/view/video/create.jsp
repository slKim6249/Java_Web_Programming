<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/Youtube/css/layout.css" />
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
  
<script type="text/javascript">
	$().ready( function(){
		
		$('#upload').click(function() {
			
			// JQuery 방식으로 Form Data 전송
			// 똑같은 폼이라도 전송이 되는 위치가 달라진다.
			// Validation Check를 하기 위해서 Jquery를 쓴다.
			// input의 id로 Valid Check
			// 이상이 있으면 return; 으로 종료
			if( $('#video').val() == "" ) {
				alert("비디오를 입력해 주세요.")
				$('#video').focus()
				return;
			}
			else if ( $('#title').val() == "" ) {
				alert("제목을 입력해 주세요.")
				$('#title').focus()
				return;
			}
			else if ( $('#uploaderId').val() == "" ) {
				alert("업로더를 입력해 주세요.")
				$('#uploaderId').focus()
				return;
			}
			else if ( $('#poster').val() == "" ) {
				alert("포스터를 선택력해 주세요.")
				$('#poster').focus()
				return;
			}
			// 모든 것이 이상이 없다면 sumbit
			$('#videoUploadForm').attr({
				'method': 'post',
				'action': '/Youtube/video/create',
				'enctype': 'multipart/form-data'
			})
			.submit()
		})
		
	})
</script>
  
</head>
<body>
	
	<!-- div를 대체하기 위해 나온 html5 시멘틱 태그 -->
	<div id="wrapper">
		<header>
			Header
		</header>
		<section class="inline"> <!-- 영역 -->
			<aside> <!-- 옆 -->
				Aside
			</aside>
			<section>
				
				<h1>Video Upload</h1>
				
				<form id="videoUploadForm" >
					<div>
						<input type="file" id="video" name="video" accept=".mp4, .avi, .wmv, .mkv"/> <!-- accept로 확장자를 정할 수 있다. -->
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
				
			</section>
		</section>
		<footer> <!-- 밑 -->
			Footer
		</footer>
	</div>
	
</body>
</html>