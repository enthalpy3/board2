<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:genericpage>
    <jsp:attribute name="head">
        <title>update</title>
    </jsp:attribute>
    <jsp:attribute name="header">
        <!-- 페이지 머리말 -->
    </jsp:attribute>
    <jsp:attribute name="footer">
        <!-- 페이지 꼬리말 -->
    </jsp:attribute>
    <jsp:body>
        <h1>게시글 수정</h1>
        <c:if test="${not empty requestScope.message }">
            <div>${requestScope.message }</div>
        </c:if>
        <c:if test="${not empty TITLE }">
            <a href="${pageContext.request.contextPath}/home.do">로그인 화면으로 돌아가기</a>
        </c:if>
        <c:if test="${empty TITLE }">
            <a href="${pageContext.request.contextPath}/DS/register_form.do">회원 가입 화면으로 돌아가기</a>
        </c:if>
    </jsp:body>
</t:genericpage>