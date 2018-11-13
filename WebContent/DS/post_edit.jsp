<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:genericpage>
    <jsp:attribute name="head">
        <title>post_info</title>
    </jsp:attribute>
    <jsp:attribute name="header">
        <!-- 페이지 머리말 -->
    </jsp:attribute>
    <jsp:attribute name="footer">
        <!-- 페이지 꼬리말 -->
    </jsp:attribute>
    
    <jsp:body>
        <h1>글수정</h1>
        <form action="${pageContext.request.contextPath}/DS/post_update.do" method="post" id="text">
                 <input type="hidden" name="id" id="id" value="${sessionScope.post.id}"/>
                 <input type="hidden" name="name" id="name" value="${sessionScope.post.name}"/>
                 <input type="hidden" name="pk" id="pk" value="${sessionScope.post.pk}"/>
            <table border=2 width="100%" style="text-align:left">
                <tr><th colspan=2>글 정보</th></tr>
                <tr><td width="10%">이름</td><td width="90%">${sessionScope.post.name}</td></tr>
                <tr><td width="10%">순번</td><td width="90%">${sessionScope.post.pk}</td></tr>
                <tr><td width="10%">제목</td><td><input style="width:100%" type="text" name="title" id="title" value="${sessionScope.post.title}"></td></tr>
                <tr><td width="10%">내용</td><td height="500px">
                <textarea name="text" cols="30" rows="10" style="width:100%; height:500px" maxlength="500" form="text">${sessionScope.post.text}</textarea>
                <%-- <input type="text" name="text" id="text" value="${sessionScope.post.text}"> --%></tr>
                <tr><td width="10%">작성날짜</td><td width="90%">${sessionScope.post.reg_date}</td></tr>
                <tr><td colspan=2><input type="submit" value="수정"></td></tr>
            </table>
        </form>
        <a href="${pageContext.request.contextPath}/DS/post_form.do">글쓰기</a>
        <a href="${pageContext.request.contextPath}/DS/post_list.do">글보기</a>
        <a href="${pageContext.request.contextPath}/DS/post_delete.do?pk=${sessionScope.post.pk}">글삭제</a>
    </jsp:body>
</t:genericpage>
