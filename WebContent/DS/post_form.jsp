<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page session="true"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.sql.*"%>
<%@page import="member.MemberDao"%>

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
	<a class="w3-bar-item w3-button w3-hover-black"
		href="${pageContext.request.contextPath}/DS/post_list.do">글보기</a>
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
        <h1>글쓰기</h1>
        <form action="${pageContext.request.contextPath}/DS/post_reg.do"
			method="post" id="text">
            <table border=2 width="100%">
                <tr>
                    <td width="10%">아이디</td>
                    <td width="90%">${sessionScope.member.id}<input
						type="hidden" name="id" value="${sessionScope.member.id}" /></td>
                </tr>
                <tr>
                    <td width="10%">이름</td>
                    <td width="90%">${sessionScope.member.name}<input
						type="hidden" name="name" value="${sessionScope.member.name}" /></td>
                </tr>
                <tr>
                    <td width="10%">제목</td>
                    <td><input placeholder="제목없음"
						style="width: 100%" type="text" name="title" maxlength="50" /></td>
                </tr>
                <tr>
                    <td width="10%">내용</td>
                    <td height="500px">
                    <textarea name="text"
							style="width: 100%; height: 500px" maxlength="500" form="text"></textarea>
                    </td>
                </tr>
                <tr style="text-align: right">
                    <td colspan=2><input type="submit" value="저장" /></td>
                </tr>
            </table>
        </form>
    </jsp:body>
</t:genericpage>

