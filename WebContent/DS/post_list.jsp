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


<t:genericpage>
	<jsp:attribute name="head">
        <title>register_form</title>
    </jsp:attribute>
	<jsp:attribute name="header">
        <!-- 머리말 추가 -->
    </jsp:attribute>
	<jsp:attribute name="footer">
        <!-- 꼬리말 추가 -->
        <script
			src="${pageContext.request.contextPath}/static/js/user.js"></script>
    </jsp:attribute>
	<jsp:body>
	
        <h1>글목록</h1>
            <table border=2>
            <tr>
			<th>순번</th>
			<th>제목</th>
			<th>내용:${getPostInfo.post.text}</th>
			<th>글쓴 날짜</th>
			<c:forEach var="i" begin="1" end="10" step="1">
			${i}
			</c:forEach>
		
		</table>
    </jsp:body>
</t:genericpage>


