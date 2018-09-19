<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/layout/layout_header.jsp" />

	<c:forEach items="${videoList.groupVideoList}" var="groupVideo">
		<div class="video-article">
			<article>
				<div>
					<img class="icon" src="<c:url value='/img/icon.png'/>" /> 
					${groupVideo.uploaderId}
				</div>
			</article>
			<div>
				<c:forEach items="${groupVideo.videoList}" var="video">
					<a href="<c:url value='/video/detail/${video.videoId}'/>">
						<article class="video">
							<div class="poster">
								<img src="<c:url value='/video/download/${video.posterPath}'/>" />
							</div> 
							<div class="title">
								${video.title}
							</div>
							<div>
								<article>
									<div class="uploader inline">
										${video.uploaderId}
									</div>
									<div class="upload-date inline">
										${video.dateDiff}
									</div>
									<div class="view-count inline">
										${video.viewCount}
									</div>
								</article>
							</div>
						</article>
					</a>
				</c:forEach>
			</div>
		</div>
	</c:forEach>
	
	<a href="<c:url value='/video/create' />">영상 업로드</a>

<jsp:include page="/WEB-INF/view/common/layout/layout_footer.jsp" />









