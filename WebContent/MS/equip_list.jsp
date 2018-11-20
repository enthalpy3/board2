<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@page import="java.sql.*" %>
<%@page import="equipment.EquipDao" %>

<nav class="w3-sidebar w3-bar-block w3-collapse w3-large w3-theme-l5 w3-animate-left" id="mySidebar">
      <a href="javascript:void(0)" onclick="w3_close()" class="w3-right w3-xlarge w3-padding-large w3-hover-black w3-hide-large" title="Close Menu">
    <i class="fa fa-remove"></i>
  </a>
  <h4 class="w3-bar-item"><b>Menu</b></h4>
  <a class="w3-bar-item w3-button w3-hover-black" href="${pageContext.request.contextPath}/MS/equip_form.do">입고등록</a>
  <a class="w3-bar-item w3-button w3-hover-black" href="${pageContext.request.contextPath}/MS/equip_assign1.do">비품배정</a>
</nav>
<t:genericpage>
    <jsp:attribute name="head">
        <title>equipment_list</title>
        <script>
        	
        </script>
    </jsp:attribute>
    <jsp:attribute name="header">
        <!-- 페이지 머리말 -->
    </jsp:attribute>
    <jsp:attribute name="footer">
        <!-- 페이지 꼬리말 -->
    </jsp:attribute>
    <jsp:body>
        <h1 id="h1">비품목록</h1>
        <table id="tableform">
        	<tr>
        		<th>모델</th>
        		<th>품명</th>
        		<th>수량</th>
        	</tr>        
        	<c:forEach items="${sessionScope.equipment}" var="listNum" >
        	<tr id="tr">
        		<td><a href="${pageContext.request.contextPath}/MS/equip_detail.do?model=${listNum.model}" >${listNum.model}</a></td>
        		<td>${listNum.equipname}</td>
        		<td>${listNum.count}</td>
        	</tr>
        	</c:forEach>
		</table>
		<h5>${sessionScope.page}</h5>
	</jsp:body>
</t:genericpage>
