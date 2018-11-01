<%@tag description="Common Page Template" pageEncoding="UTF-8"%>
<%@attribute name="head" fragment="true"%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<!-- 반응형 메타태그 - 부트스트랩은 Mobile First -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap/4.1.3/css/bootstrap.min.css">
<!-- 개별 페이지의 head -->
<jsp:invoke fragment="head" />
</head>
<body>
	<div class="container">
		<header>
			<jsp:include page="/common/top.jsp" flush="false" />
			<!-- 개별 페이지의 header -->
			<jsp:invoke fragment="header" />
		</header>
		<div id="body"><jsp:doBody /></div>
		<footer>
			<!-- 개별 페이지의 footer -->
			<jsp:invoke fragment="footer" />
			<jsp:include page="/common/bottom.jsp" flush="false" />
		</footer>
		<!-- 옵션: jQuery, Popper.js, Bootstrap JS 순으로 추가 -->
		<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.min.js"></script>
		<script>
			$(document).ready(function() {

				var good = $("#success");
				var id = $("#id");
				var pw = $("#pw");
				var pw2 = $("#pw2");
				var name = $("#name");
				var phone = $("#phone");
				var email = $("#email");
			});

			function check() {

				/* 영어, 숫자만 허용 특수문자 제외  */
				var idReg = /^[a-z]+[a-z0-9]{5,19}$/g;
				if (!idReg.test($("input[name=id]").val())) {
					alert("아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다.");
					return false;
				}

				/* 비밀번호는 영문 숫자 특수문자만 허용 */
				var pwReg = /^[a-zA-Z`~!@#$%^&*|\\\'\";:\/?0-9]{8,20}$/g;
				if (!pwReg.test($("input[name=pass]").val())) {
					alert("8~20자 영문자 또는 숫자이어야 합니다. 특수문자가능");
					return false;
				} else if (user.pass.value != user.pass2.value) {
					alert("비밀번호가 일치하지 않습니다.");
					return false;
				}

				/* 한글 영어만 가능 */
				var nameReg = /^[가-힣]{2,10}$/g;
				if (!nameReg.test($("input[name=name]").val())) {
					alert("2~10자 영문,한글 또는 숫자이어야 합니다.");
					return false;
				}
				/* 숫자만 가능 */
				var phoneReg = /^[0-9]{11}$/g;
				if (!phoneReg.test($("input[name=phone]").val())) {
					alert("-를 제외한 숫자이어야 합니다.");
					return false;
				}
				/* @ 이를 포함 영어와 숫자만 가능 */
				var emailReg = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/g;
				if (!emailReg.test($("input[name=email]").val())) {
					alert("올바른 형식이 아닙니다.");
					return false;
				}
			}
		</script>
		<script
			src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.slim.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/static/js/popper.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/static/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	</div>
</body>
</html>