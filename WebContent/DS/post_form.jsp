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
                method="post" id="text">
            <table border=2 width="100%">
                <tr>
                    <td width="10%">아이디</td>
                    <td width="90%">${sessionScope.member.id}<input type="hidden" name="id" value="${sessionScope.member.id}"/></td>
                </tr>
                <tr>
                    <td width="10%">이름</td>
                    <td width="90%">${sessionScope.member.name}<input type="hidden" name="name" value="${sessionScope.member.name}"/></td>
                </tr>
                <tr>
                    <td width="10%">제목</td>
                    <td><input placeholder="제목없음" style="width:100%" type="text" name="title" maxlength="50"/></td>
                </tr>
                <tr>
                    <td width="10%">내용</td>
                    <td height="500px">

                   <!--  <input type="hidden" name="text" id="text" /> -->
                    <textarea name="text" style="width:100%; height:500px" maxlength="500" form="text"></textarea>

                    </td>
                </tr>
                <tr>
                    <td colspan=2><input type="submit" value="저장" /></td>
                </tr>
            </table>
        </form>
    </jsp:body>
</t:genericpage>
