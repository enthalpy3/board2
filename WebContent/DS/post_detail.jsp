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
            <table border=2 width="100%" style="text-align:left">
                <tr width="100%">
				<th colspan=2>글정보</th>
				<h1>${sessionScope.post.id}</h1>
			</tr>
                <tr>
				<td width="10%">이름</td>
				<td>${sessionScope.post.name}</td>
			</tr>
                <tr>
				<td width="10%">제목</td>
				<td width="90%">${sessionScope.post.title}</td>
			</tr>
                <tr width="10%">
				<td>내용</td>
				<td style="hight: 200px">${sessionScope.post.text}</td>
			</tr>
                <tr>
				<td width="10%">작성날짜</td>
				<td>${sessionScope.post.reg_date}</td>
			</tr>
                <tr>
				<td width="10%">test</td>
				<td>정상작동</td>
			</tr>
            </table>
         <a href="${pageContext.request.contextPath}/DS/post_form.do">글쓰기</a>
         <c:if test="${sessionScope.member.id eq sessionScope.post.id}">
         <a href="${pageContext.request.contextPath}/DS/post_edit.do?=${sessionScope.post.pk}">수정하기</a>
         </c:if>
        <a href="${pageContext.request.contextPath}/DS/post_list.do">글보기</a>
      
    </jsp:body>
</t:genericpage>
