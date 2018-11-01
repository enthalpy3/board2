<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:genericpage>
    <jsp:attribute name="head">
        <title>register_form</title>
    </jsp:attribute>
    <jsp:attribute name="header">
        <!-- 머리말 추가 -->
    </jsp:attribute>
    <jsp:attribute name="footer">
        <!-- 꼬리말 추가 -->
        <script src="${pageContext.request.contextPath}/static/js/user.js"></script>
    </jsp:attribute>
    <jsp:body>
        <h1>글쓰기</h1>
        <form action="${pageContext.request.contextPath}/DS/post_reg.do"
                method="post">
            <table>
                <tr>
                    <td>이름</td>
                    <td><input type="text" name="name" value="${sessionScope.member.name}"/></td>
                </tr>
                <tr>
                    <td>제목</td>
                    <td><input type="text" name="title" /></td>
                </tr>
                <tr>
                    <td>내용</td>
                    <td><input type="text" name="text" /></td>
                </tr>
                <tr>
                    <td colspan=2><input type="submit" value="저장" /></td>
                </tr>
            </table>
        </form>
    </jsp:body>
</t:genericpage>
