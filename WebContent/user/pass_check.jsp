<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
	<jsp:attribute name="head">
        <title>index.jsp</title>
    </jsp:attribute>
	<jsp:attribute name="header">
        <!-- 머릿말 추가 -->
    </jsp:attribute>
	<jsp:attribute name="footer">
        <!-- 꼬릿말 추가 -->
    </jsp:attribute>

	<jsp:body>

        <c:if test="${not empty ID }">
            <form action="${pageContext.request.contextPath}/user/edit.do" method="post">
                <table>
                	
                	<tr>
                		<td>비밀번호</td>
                		<td><input type="password" name="pass" /></td>
                	</tr>
                	<tr>
                		<td colspan="2"><input type="submit" value="회원정보 수정하기" /></td>
                	</tr>
                </table>
            </form>
        </c:if>

    </jsp:body>
</t:genericpage>