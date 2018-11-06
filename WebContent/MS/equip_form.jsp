<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@page import="java.sql.*" %>
<%@page import="equipment.EquipDao" %>

<t:genericpage>
    <jsp:attribute name="head">
        <title>equipment_form</title>
    </jsp:attribute>
    <jsp:attribute name="header">
        <!-- 페이지 머리말 -->
    </jsp:attribute>
    <jsp:attribute name="footer">
        <!-- 페이지 꼬리말 -->
        <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.slim.min.js"></script>
    </jsp:attribute>
    <jsp:body>
        <h1>비품등록</h1>
        <form action="${pageContext.request.contextPath}/MS/equip_reg.do" method="post">
            <table>
                <tr>
                    <td>품명</td>
                    <td><input type="text" name="equipname"/></td>
                </tr>
                <tr>
                    <td>모델번호</td>
                    <td><input type="text" name="model" /></td>
                </tr>
                <tr>
                    <td>수량</td>
                    <td><input type="text" name="" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="등록" onSubmit="return check()" /></td>
                	<td><input type="reset" value="취소" /></td>
                </tr>
            </table>
        </form>
    </jsp:body>
</t:genericpage>
        