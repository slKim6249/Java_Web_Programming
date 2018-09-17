<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script> -->
    <!-- header 와 footer 중복을 막기위해 따로 jsp파일을 만들고 불러오기. -->
<jsp:include page="/WEB-INF/view/common/layout/layout_header.jsp" /> 

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
                     , top:"-100px"
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
      <video   preload="metadata"
            autoplay controls="controls" 
            poster="<c:url value='/video/download/${video.posterPath}' />">
         <source src="<c:url value='/video/download/${video.videoPath}' />" />
      </video>
      <div id = "subscript" style="background-color: rgba(0,0,0,0.3); display : none">
      </div>
   </div>
   <div>
      ${video.title}
   </div>
   <div>
      <img src="https://t1.daumcdn.net/cfile/tistory/182459414F21622D23"
          id="icon" /> ${video.uploaderId}
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