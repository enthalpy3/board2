<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@page import="java.sql.*" %>
<%@page import="equipment.EquipDao" %>

<t:genericpage>
    <jsp:attribute name="head">
        <title>equipment_detail</title>
    </jsp:attribute>
    <jsp:attribute name="header">
        <!-- 페이지 머리말 -->
    </jsp:attribute>
    <jsp:attribute name="footer">
		<a href="${pageContext.request.contextPath}/MS/equip_list.do"><button>입고목록</button></a>
    </jsp:attribute>
    <jsp:body>
        <h1>비품상세보기</h1>
        <h5>품명 : ${sessionScope.equip.equipname}</h5>
        <h5>모델번호 : ${sessionScope.equip.model}</h5>
        <table>
        	<tr>
        		<td>처리날짜</td>
        		<td>상태</td>
        		<td>수량</td>
        	</tr>
        	<c:forEach items="${sessionScope.equipment}" var="list" >
        	<tr>
        		<td>${list.date}</td>
        		<td>${list.state}</td>
        		<td>${list.count}</td>
        	</tr>
       		</c:forEach>
       		<tr>
       			<td>${sessionScope.username.username}</td>
        	</tr>
        </table>
    </jsp:body>
</t:genericpage>