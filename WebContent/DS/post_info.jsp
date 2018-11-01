<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:genericpage>
    <jsp:attribute name="head">
        <title>상세보기</title>
    </jsp:attribute>
    <jsp:attribute name="header">
        <!-- 페이지 머리말 -->
    </jsp:attribute>
    <jsp:attribute name="footer">
        <!-- 페이지 꼬리말 -->
    </jsp:attribute>
    <jsp:body>
        <h1>상세정보</h1>
        <form action="${pageContext.request.contextPath}/DS/post_update.do" method="post">
            <input type="hidden" name="name" value="${sessionScope.member.id}"/>
            <table>
                <tr><th colspan=2>글정보</th></tr>
                <tr><td>이름</td><td>${sessionScope.member.name}</td></tr>
                <tr><td>제목</td><td><input type="text" name="title" value="${sessionScope.post.title}"></td></tr>
                <tr><td>내용</td><td><input type="text" name="text" value="${sessionScope.post.text}"></td></tr>
                <tr><td>작성날짜</td><td>${sessionScope.post.reg_date}</td></tr>
                <tr><td>test</td><td>정상작동</td></tr>
                <tr><td colspan=2><input type="submit" value="수정"></td></tr>
            </table>
        </form>
        
        <a href="${pageContext.request.contextPath}/DS/post_delete.do?=${TITLE}">삭제</a>
    </jsp:body>
</t:genericpage>
