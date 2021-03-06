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
  <a class="w3-bar-item w3-button w3-hover-black" href="${pageContext.request.contextPath}/MS/equip_list.do?page=1">비품목록</a>
</nav>

<t:genericpage>
    <jsp:attribute name="head">
        <title>equipment_detail</title>
    </jsp:attribute>
    <jsp:attribute name="header">
        <!-- 페이지 머리말 -->
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1 id="h1">비품상세보기</h1>
        <h5>품명 : ${sessionScope.equip.equipname}</h5>
        <h5>모델 : ${sessionScope.equip.model}</h5>
        <table id="tableform">
        	<tr>
        		<th>상태</th>
        		<th>수량</th>
        		<th>입고날짜</th>
        		<th>폐기날짜</th>
        	</tr>
        	<c:forEach items="${sessionScope.equipment}" var="list" >
        	<tr id="tr">      
        		<td>${list.state}</td>
        		<td>${list.count}</td>
        		<td>${list.date}</td>
        		<td>${list.reg_date3}</td>
        	</tr>
       		</c:forEach>
       		<tr><td><h5 id="h5">현재 사용자 명단</h5></td></tr>
       		<c:forEach items="${sessionScope.username}" var="user" >
        	<tr id="tr2">
        		<td>${user.username}</td>
        		<td>
        		<form action="${pageContext.request.contextPath}/MS/equip_return.do" method="post" id="lmsform">
        			<input type="hidden" name="num" value="${user.num}"/>
        			<input type="hidden" name="username" value="배정가능"/>
        			<input type="submit" value="반납" />
        		</form>
        		</td>
        	</tr>
       		</c:forEach>       		
       		<tr><td><h5 id="h5">배정 가능 비품</h5></td></tr>
       		<c:forEach items="${sessionScope.assignEquip}" var="assignEquip" >
        	<tr id="tr2">
        		<td>${assignEquip.num}</td>
        		<td>
        		<a href="${pageContext.request.contextPath}/MS/equip_assign2.do?num=${assignEquip.num}" ><button>비품배정</button></a>
        		</td>
        		<td>
        		<form action="${pageContext.request.contextPath}/MS/equip_disposal.do" method="post" id="lmsform">
        			<input type="hidden" name="num" value="${assignEquip.num}"/>
        			<input type="submit" value="폐기" />
        		</form>
        		</td>
        	</tr>
       		</c:forEach>       		
        </table>
    </jsp:body>
</t:genericpage>