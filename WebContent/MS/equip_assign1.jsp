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
  <a class="w3-bar-item w3-button w3-hover-black" href="${pageContext.request.contextPath}/MS/equip_list.do">입고목록</a>
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
            <table>
                <tr>
                    <td>품명</td>
                    <td><input type="text" name="equipname" /></td>
                </tr>
                <tr>
                    <td>고유번호</td>
                    <td><input type="text" name="num" /></td>
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
                <tr>
                    <td><input type="submit" value="등록" /></td>
                	<td><input type="reset" value="취소" /></td>
                </tr>
            </table>
        </form>
    </jsp:body>
</t:genericpage>