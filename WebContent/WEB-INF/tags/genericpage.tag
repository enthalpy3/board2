<%@tag description="Common Page Template" pageEncoding="UTF-8"%>
<%@attribute name="head" fragment="true"%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<!-- 반응형 메타태그 - 부트스트랩은 Mobile First -->
<title>김도성</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap/4.1.3/css/bootstrap.min.css">
<!-- 개별 페이지의 head -->
<jsp:invoke fragment="head" />
</head>
<style>
html, body, h1, h2, h3, h4, h5, h6 {
	font-family: "Roboto", sans-serif;
}

.w3-sidebar {
  z-index: 3;
  width: 250px;
  top: 43px;
  bottom: 0;
  height: inherit;
}

#tableform {
width : 75%;
text-align:center;
border-bottom:1px solid lightgray;
}

#table2 tr td{
border-right:1px solid #EDEDED;
}

#tr {
line-height:200%;
}

#tr td {
border-top:1px solid #EDEDED;
}

#tr2 {
line-height:130%;
}

#tr2 td {
border-top:1px solid #EDEDED;
}
#assign tr td {
padding-right:25px;
}

#lmsform {
margin-bottom:0px;
}

#h1 {
width:75%;
padding-bottom : 25px;
margin-bottom : 25px;
border-bottom : 1px solid lightgray;
}
#button1 {
width:280px;
padding: 20px 0px 0px 170px;
margin-top : 20px;
border-top : 1px solid lightgray;
}
#button2 {
width:30%;
padding: 20px 0px 0px 100px;
margin-top : 20px;
border-top : 1px solid lightgray;
}

#h5 {
padding:30px 0px 5px 0px;
}
#modelh5 {
padding-bottom:20px;
}

</style>
<body>

	<header>
		<jsp:include page="/common/top.jsp" flush="false" />
		<!-- 개별 페이지의 header -->
		<jsp:invoke fragment="header" />
	</header>
	<div class="container">

		<div class="w3-row w3-padding-64">
			<div class="w3-twothird w3-container">
				<h1 class="w3-text-teal"></h1>



				<div id="body"><jsp:doBody /></div>
			</div>


			<div class="w3-third w3-container">
				<p class="w3-border w3-padding-large w3-padding-32 w3-center">광고받습니다.</p>
				<p class="w3-border w3-padding-large w3-padding-64 w3-center">AD</p>
				
			</div>
		</div>
		<footer>
			<!-- 개별 페이지의 footer -->
			<jsp:invoke fragment="footer" />
			<jsp:include page="/common/bottom.jsp" flush="false" />
		</footer>
		<!-- 옵션: jQuery, Popper.js, Bootstrap JS 순으로 추가 -->
		<script
			src="${pageContext.request.contextPath}/static/js/validation.js"></script>
		<script
			src="${pageContext.request.contextPath}/static/js/event.js"></script>
		<script
			src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.slim.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/static/js/popper.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/static/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	</div>
</body>
</html>