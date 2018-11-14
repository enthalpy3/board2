<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div class="w3-bar w3-theme w3-left-align w3-large w3-theme-l1">
	   <a class="w3-bar-item w3-button w3-right w3-hide-large w3-hover-white w3-large w3-theme-l1" href="javascript:void(0)" onclick="w3_open()"><i class="fa fa-bars"></i></a>
			<a href="${pageContext.request.contextPath}"
			class="w3-bar-item w3-button w3-theme-l1">home</a> 
			<a href="${pageContext.request.contextPath}/DS/post_list.do" class="w3-bar-item w3-button w3-hide-small w3-hover-white">글보기</a> <a
			href="${pageContext.request.contextPath}/MS/equip_list.do" class="w3-bar-item w3-button w3-hide-small w3-hover-white">비품목록</a>
		<c:if test="${not empty ID }">
			<a href="${pageContext.request.contextPath}/user/member_info.do" class="w3-bar-item w3-button w3-hide-small w3-hover-white">${ID }님</a>
			<a href="${pageContext.request.contextPath}/user/logout.do" class="w3-bar-item w3-button w3-hide-small w3-hover-white">로그아웃</a>
		</c:if>
		<c:if test="${empty ID }">
		<a href="${pageContext.request.contextPath}/user/register_form.do"
			class="w3-bar-item w3-button w3-hide-small w3-hide-medium w3-hover-white">회원가입</a>
</c:if>
</div>
	
		