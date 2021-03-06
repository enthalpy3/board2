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
        <title>equipment_assign</title>
    </jsp:attribute>
    <jsp:attribute name="header">
        <!-- 페이지 머리말 -->
    </jsp:attribute>
    <jsp:attribute name="footer">
        <!-- 페이지 꼬리말 -->
    </jsp:attribute>
    <jsp:body>
        <h1 id="h1">비품배정</h1>
        <form action="${pageContext.request.contextPath}/MS/equip_assign_reg.do" method="post">
            <table id="assign">
                <tr>
                    <td>품명</td>
                    <td>${sessionScope.equip.equipname}</td>
                    <td><input type="hidden" name="equipname" value="${sessionScope.equip.equipname}"/></td>
                </tr>
                <tr>
                    <td>고유번호</td>
                    <td>${sessionScope.equip.num}</td>
                	<td><input type="hidden" name="num" value="${sessionScope.equip.num}"/></td>
                </tr>
                <tr>
                    <td>사용자 이름</td>
                <td>
                <select name="username">
                <c:forEach items="${sessionScope.username}" var="username" >
                	<option value="${username.name}">${username.name}</option>
        		</c:forEach>
        		</select>
        		</td>
                </tr>
            </table>
            <div id="button2">
            	<input type="submit" value="등록" />
            	<input type="reset" value="취소" />
            </div>
        </form>
    </jsp:body>
</t:genericpage>
        