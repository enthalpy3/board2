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
        <h1>비품목록</h1>
        <table>
        	<tr>
        		<td>모델번호</td>
        		<td>품명</td>
        		<td>수량</td>
        	</tr>        
        	<c:forEach items="${sessionScope.equipment}" var="listNum" >
        	<tr>
        		<td><a href="${pageContext.request.contextPath}/MS/equip_detail.do?model=${listNum.model}" >${listNum.model}</a></td>
        		<td>${listNum.equipname}</td>
        		<td>${listNum.count}</td>
        	</tr>
        	</c:forEach>		
		</table>
		<%-- <a href="${pageContext.request.contextPath}/MS/equip_form.do">입고등록</a>		
		<a href="${pageContext.request.contextPath}/MS/equip_assign1.do">비품배정</a> --%>
    </jsp:body>
</t:genericpage>

        <%-- <form action="${pageContext.request.contextPath}/user/update.do" method="post">
            <table>
                <tr><th colspan=2>회원정보</th></tr>
                <tr><td>${sessionScope.equipment.equipname}</td>
                <td>${sessionScope.equipment.model}</td></tr>
                <tr><td colspan=2><input type="submit" value="수정"></td></tr>
            </table>
        </form> --%>
        
        
        <%-- <%
        request.setCharacterEncoding("utf-8");		
		EquipDao data = new EquipDao();
		String rPath = request.getContextPath();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;		
		
		String url = "jdbc:mysql://localhost:3306/lteam";
		String user = "jsp_user";
		String pass = "qqsseer1";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from equipment");
			while (rs.next()) {
				out.println("<tr>");
				out.println("<td>" + rs.getString("equipname") + "</td>");
				out.println("<td>" + rs.getString("model") + "</td>" + "<br>");
				out.println("</tr>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>
 --%>