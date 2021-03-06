<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:genericpage>
    <jsp:attribute name="head">
        <title>register</title>
    </jsp:attribute>
    <jsp:attribute name="header">
        <!-- 페이지 머리말 -->
    </jsp:attribute>
    <jsp:attribute name="footer">
        <!-- 페이지 꼬리말 -->
    </jsp:attribute>
    <jsp:body>
        <h1>비품반납</h1>
        <c:if test="${not empty requestScope.message }">
            <div>${requestScope.message }</div>
        </c:if>
        <c:if test="${not empty ID }">
            <a href="${pageContext.request.contextPath}/MS/equip_list.do?page=1">비품목록 페이지로 돌아가기</a>
        </c:if>
        <c:if test="${empty ID }">
            <a href="${pageContext.request.contextPath}/MS/equip_detail.do">상세페이지로 돌아가기</a>
        </c:if>
    </jsp:body>
</t:genericpage>