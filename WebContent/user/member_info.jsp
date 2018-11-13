<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:genericpage>
    <jsp:attribute name="head">
        <title>member_info</title>
    </jsp:attribute>
    <jsp:attribute name="header">
        <!-- 페이지 머리말 -->
    </jsp:attribute>
    <jsp:attribute name="footer">
        <!-- 페이지 꼬리말 -->
    </jsp:attribute>
    
    <jsp:body>
        <h1>회원정보</h1>
        <form action="${pageContext.request.contextPath}/user/update.do" method="post" onSubmit="return check();" id="form">
            <input type="hidden" name="id" value="${sessionScope.member.id}"/>
            <table>
                <tr><th colspan=2>회원정보</th></tr>
                <tr><td>아이디</td><td>${sessionScope.member.id}</td></tr>
                <tr><td>비밀번호</td><td><input type="password" name="pass" id="pass" value="${sessionScope.member.pass}"></td></tr>
                <tr><td>비밀번호체크</td><td><input type="password" name="pass2" id="pass2" value="${sessionScope.member.pass}"></td></tr>
                <tr><td>이름</td><td><input type="text" name="name" id="name" value="${sessionScope.member.name}"></td></tr>
                <tr><td>전화번호</td><td><input type="text" name="phone" id="phone" value="${sessionScope.member.phone}"></td></tr>
                <tr><td>이메일</td><td><input type="text" name="email" id="email" value="${sessionScope.member.email}"></tr>
                <tr><td>추천인</td><td><input type="text" name="recommender" id="recommender" value="${sessionScope.member.recommender}"></tr>
                <tr><td>가입날짜</td><td>${sessionScope.member.reg_date}</td></tr>
                <tr><td colspan=2><input type="submit" value="수정"></td></tr>
            </table>
        </form>
        <br />
        <a href="${pageContext.request.contextPath}/MS/equip_list.do">비품목록</a>
        <a href="${pageContext.request.contextPath}/DS/post_form.do">글쓰기</a>
        <a href="${pageContext.request.contextPath}/DS/post_list.do">글보기1</a>
        <a href="${pageContext.request.contextPath}/DS/post_list.do2">글보기2</a>
        <a href="${pageContext.request.contextPath}/user/delete.do?=${ID}">회원탈퇴</a>
    </jsp:body>
</t:genericpage>
