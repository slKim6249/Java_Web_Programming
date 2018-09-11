<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/layout/layout_header.jsp" /> <!-- 해당 경로에 있는 파일을 이 부분에 채워 넣는다. -->

	<div>
		<video poster="<c:url value='/video/poster/${video.posterPath}' /> "> <%-- <c:url value='' -> /video 앞에 있는 url부분을 채워준다 --%>
			<source src="<c:url value='/video/video/${video.videoPath}' /> ">
		</video>
	</div>
	<div>
		${video.title}
	</div>
	<div>
		<img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAAclBMVEU7V53///8yUZogRZXn6vKKl785VZxAW6Dh5O5yg7QmSZbR1uU2U5skR5ZNZqWps9DK0OKTn8QrTJhlea57i7nw8ve+xttccqva3uqyu9Vpe7CPnMKapsjj5/Bsf7K6wtkAMY2Bj7sVP5JTa6j19/ukrs1FoiZVAAAD+klEQVR4nO3dbW+bMBSGYWOIkzrmzSRpurbrutL//xeXl0bdNI06YfY5x3puqeqnUi4BcYKBqOKjrh+WKpeWQ99dYOr8q3VWO0O9Yv8t47R17W/CqrHU6xQh21QX4d466rWJkrP7s7Cq89k9/8zU1UnY5LkFj7nmKGxzPAYv2fYgzHcLHnOF6mrqlYha3aleU69E1HSvhsz30m9qmetQcc7k81YUIYQQQgghhBBCCKFbc9p7W39WHn6stf6Q1trIPkdotK/dsGh361U1jkVRjOO43VbPq/262708vPeLzdAYXwudNXO+bha7qvi67UrJIxpfvrUhuo8pbGkZ7/vnYJ48ofHm4RqeOKH27ZU+WUJTvo5XAyUJtVtf75MktN9v8QkSlk+3AcUIy2tfQqUJy92tQCHCGUAZwvr6UVCW0C9mACUI3dscoAChsdvMhfbmcUKI0N3PA/IXlqvMhfp1JpC9sA4/XSFTOH8TchfOPgq5C83cF1L2Qv+Su9DOB/IW6k3uQj/jY6EM4cz33PyFMz82CRDqx+ss29V+/Vd7znNPVxyG4+610cfJ0b9jDFQ29A3N86b2Emd8jQ4E9qXQ25ZMEwYcPPWa3pq+CwLeiQUq3YcAHwTfOhg2Gyr0EDwVNFi8SL6B13ZfA4vvku+NtCFTvlreKPhZHTDgrwS/zhyEAZfN7CQfhqoMOJHYyh0MVZjwSfJgESR8zF64gJB1EELIPwgh5B+EEPIPQgj5ByGE/IMQQv7lITT/LlA4sYTTUqhbTmRDhGZqCcdojS5slndOFe1p/8B57Dl12QsfaCc2EgiJn5+bQLjJXvhGOwueQEg8zR9fOBLPgscXUs/zxxcSD4cJhNTz/PGF1LPg8YXUl0zFFzbEH5/iC33uwi31RWHRhfvshTvqi8KiC9+zF5KfiosuJP92lehC8m9XiS0cqQ/D6MKKerCILlyTXyMdW0h8KjGBkP4a6djCDfVgEV14Tz1YRBdS+6IL6YfD2ELqU4nxhdSnEtXxe/mq1UQBiKm/f34nHywOxHqiHwF3dr3+nFgAA+B0eVyLMRWEEPIPQgj5ByGE/IMQQv5BCCH/IISQfxBCyD8IIeQfhBDyD0II+QchhPyDEEL+QQgh/yCEkH8QQsg/CCHkH4QQ8g9CCPkHIYT8gxBC/kEIIf8ghJB/EELIPwgh5F9CIdFTz1IJzVIRPbkuldANiujZ9KmEulcdzZNsUgltp4ge3Z5sLy1U0ZI8rCeR0LYHYdFQbMU0QtcUR2FlCQaMJEJTVydhsa/Tb8UUQmf3xVlYVE3yYzGB0Dan/6HOC2ud1S7lzhpXaJy2rj0vRV0W1/XD8n8SviiucDn03WUpvwDZiExyVZmqhQAAAABJRU5ErkJggg=="
			 id="icon" />${video.uploaderId}
	</div>

<jsp:include page="/WEB-INF/view/common/layout/layout_footer.jsp" />