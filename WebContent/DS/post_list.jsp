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

<%
	request.setCharacterEncoding("utf-8");
%>
<%
	String rPath = request.getContextPath();
%>


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
			<th width="5%">이름</th>
			<th width="25%">제목</th>
			<th width="50%">내용</th>
			<th width="8%">글쓴날짜</th>
			<th width="7%">상세보기</th>
			<h1>${sessionScope.post}</h1>
			
		<jsp:include page="/DS/post_list2.jsp" flush="false" />
			
		</table>
		<a href="${pageContext.request.contextPath}/DS/post_form.do">글쓰기</a>
        <a href="${pageContext.request.contextPath}/DS/post_list.do">글보기1</a>
     <%--    <a href="${pageContext.request.contextPath}/DS/post_list.do2">글보기2</a> --%>
    </jsp:body>
</t:genericpage>


