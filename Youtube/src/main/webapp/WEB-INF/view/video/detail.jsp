<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
<jsp:include page="/WEB-INF/view/common/layout/layout_header.jsp" /> <!-- 해당 경로에 있는 파일을 이 부분에 채워 넣는다. -->

	<script type="text/javascript">
      $().ready(function(){
         setInterval(function(){
            var time=parseInt($("video").prop("currentTime"));
            $("#subscriptList").find("li").each(function(index, li){
               var start = parseInt($(li).data("start"));
               var end = parseInt($(li).data("end"));
               if ( time >= start && time <= end){
                  $("#subscript").css({
                     position:"relative"
                     , "z-index": 9
                     , width:$("video").css("width") + "px"
                     , padding:"15px, 0px"
                     , "font-size":"13pt"
                     , top:"-50px"
                     , color:"#FFF"
                     , "text-align": "center"
                  })
                  .html($(li).html())
                  .show();
                  if ( time== end ){
                     $("#subscript").hide();
                  }
               }
            })
         }, 1000);
      });
   </script>


	<div>
		<video preload="metadata"
		       autoplay 
			   controls="controls"
			   poster="<c:url value='/video/download/${video.posterPath}' /> " > <%-- <c:url value='' -> /video 앞에 있는 url부분을 채워준다, JSP에서는 주석을 !대신 %로 --%>
			<source src="<c:url value='/video/download/${video.videoPath}' /> " >
		</video>
		<div id = "subscript" style="background-color: rgba(0,0,0,0.3); display : none">
	    </div>
	</div>
	
	<div>
		${video.title}
	</div>
	
	<div>
			<img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAAclBMVEU7V53///8yUZogRZXn6vKKl785VZxAW6Dh5O5yg7QmSZbR1uU2U5skR5ZNZqWps9DK0OKTn8QrTJhlea57i7nw8ve+xttccqva3uqyu9Vpe7CPnMKapsjj5/Bsf7K6wtkAMY2Bj7sVP5JTa6j19/ukrs1FoiZVAAAD+klEQVR4nO3dbW+bMBSGYWOIkzrmzSRpurbrutL//xeXl0bdNI06YfY5x3puqeqnUi4BcYKBqOKjrh+WKpeWQ99dYOr8q3VWO0O9Yv8t47R17W/CqrHU6xQh21QX4d466rWJkrP7s7Cq89k9/8zU1UnY5LkFj7nmKGxzPAYv2fYgzHcLHnOF6mrqlYha3aleU69E1HSvhsz30m9qmetQcc7k81YUIYQQQgghhBBCCKFbc9p7W39WHn6stf6Q1trIPkdotK/dsGh361U1jkVRjOO43VbPq/262708vPeLzdAYXwudNXO+bha7qvi67UrJIxpfvrUhuo8pbGkZ7/vnYJ48ofHm4RqeOKH27ZU+WUJTvo5XAyUJtVtf75MktN9v8QkSlk+3AcUIy2tfQqUJy92tQCHCGUAZwvr6UVCW0C9mACUI3dscoAChsdvMhfbmcUKI0N3PA/IXlqvMhfp1JpC9sA4/XSFTOH8TchfOPgq5C83cF1L2Qv+Su9DOB/IW6k3uQj/jY6EM4cz33PyFMz82CRDqx+ss29V+/Vd7znNPVxyG4+610cfJ0b9jDFQ29A3N86b2Emd8jQ4E9qXQ25ZMEwYcPPWa3pq+CwLeiQUq3YcAHwTfOhg2Gyr0EDwVNFi8SL6B13ZfA4vvku+NtCFTvlreKPhZHTDgrwS/zhyEAZfN7CQfhqoMOJHYyh0MVZjwSfJgESR8zF64gJB1EELIPwgh5B+EEPIPQgj5ByGE/IMQQv7lITT/LlA4sYTTUqhbTmRDhGZqCcdojS5slndOFe1p/8B57Dl12QsfaCc2EgiJn5+bQLjJXvhGOwueQEg8zR9fOBLPgscXUs/zxxcSD4cJhNTz/PGF1LPg8YXUl0zFFzbEH5/iC33uwi31RWHRhfvshTvqi8KiC9+zF5KfiosuJP92lehC8m9XiS0cqQ/D6MKKerCILlyTXyMdW0h8KjGBkP4a6djCDfVgEV14Tz1YRBdS+6IL6YfD2ELqU4nxhdSnEtXxe/mq1UQBiKm/f34nHywOxHqiHwF3dr3+nFgAA+B0eVyLMRWEEPIPQgj5ByGE/IMQQv5BCCH/IISQfxBCyD8IIeQfhBDyD0II+QchhPyDEEL+QQgh/yCEkH8QQsg/CCHkH4QQ8g9CCPkHIYT8gxBC/kEIIf8ghJB/EELIPwgh5F9CIdFTz1IJzVIRPbkuldANiujZ9KmEulcdzZNsUgltp4ge3Z5sLy1U0ZI8rCeR0LYHYdFQbMU0QtcUR2FlCQaMJEJTVydhsa/Tb8UUQmf3xVlYVE3yYzGB0Dan/6HOC2ud1S7lzhpXaJy2rj0vRV0W1/XD8n8SviiucDn03WUpvwDZiExyVZmqhQAAAABJRU5ErkJggg=="
			 id="icon" />${video.uploaderId}
	</div>
	
	<div style="display:none;">
      <ul id="subscriptList">
         <li data-start="3" data-end="5">안녕하세요</li>
         <li data-start="7" data-end="15">오늘은 동영상 자막에<br/> 대해 알아볼게요</li>
         <li data-start="17" data-end="25">자막은 Floating Div를<br/> 이용해 구현합니다.</li>
         <li data-start="27" data-end="35">배경은 Alpha 값으로 <br/>투명하게 지정할 수 있어요.</li>
         <li data-start="37" data-end="53">감사합니다.</li>
      </ul>
   </div>


<jsp:include page="/WEB-INF/view/common/layout/layout_footer.jsp" />