<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="elfunc" uri="ElFunctions"%>



<nav
	class="w3-sidebar w3-bar-block w3-collapse w3-large w3-theme-l5 w3-animate-left"
	id="mySidebar">
	<a href="javascript:void(0)" onclick="w3_close()"
		class="w3-right w3-xlarge w3-padding-large w3-hover-black w3-hide-large"
		title="Close Menu"> <i class="fa fa-remove"></i>
	</a>
	<h4 class="w3-bar-item">
		<b>Menu</b>
	</h4>
	<c:if test="${not empty ID }">
		<a class="w3-bar-item w3-button w3-hover-black"
			href="${pageContext.request.contextPath}/DS/post_form.do">글쓰기</a>
	</c:if>
</nav>

<t:genericpage>
	<jsp:attribute name="head">
        <title>register_form</title>
    </jsp:attribute>
	<jsp:attribute name="header">
        <!-- 머리말 추가 -->
    </jsp:attribute>
	<jsp:attribute name="footer">
        <!-- 꼬리말 추가 -->
       
    </jsp:attribute>
	<jsp:body>
        <h1>글목록</h1>
            <table border=2 width="100%">
            <tr>
			<th width="5%">순번</th>
			<th width="8%">이름</th>
			<th width="72%">제목</th>
			<th width="15%">글쓴날짜</th>
		<jsp:include page="/DS/post_list2.jsp" flush="false" />
		
		</table>
    </jsp:body>
</t:genericpage>


