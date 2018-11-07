<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
	request.setCharacterEncoding("utf-8");
%>
<%
	String rPath = request.getContextPath();
%>

<%
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String url = "jdbc:mysql://localhost:3306/lteam?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	String user = "root";
	String pw = "zxcv1234";

	try {
		// mysqlbd 주소
		// Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		// mariadb 주소
		Class.forName("org.mariadb.jdbc.Driver");
		con = DriverManager.getConnection(url, user, pw);
		stmt = con.createStatement();
		rs = stmt.executeQuery("select * from post ORDER BY pk DESC");
		while (rs.next()) {
			out.print("<tr>");
			out.print("<td>"+"<span id="+"\"demo\""+">"+ rs.getString("pk")+"</span>"+ "</td>");
			out.print("<td>" + rs.getString("name") + "</td>");
			out.print("<td>" + "<h3><a href=\"" + rPath + "/DS/post_info.do\"" + ">");
			out.print(rs.getString("title") + "</a></h3>" + "</td>");
			//out.print("<td>" + rs.getString("title") + "</td>");

			out.print("<td>" + rs.getString("text") + "</td>");
			out.print("<td>" + rs.getString("reg_date") + "</td>");
			out.print("</tr>");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
%>

