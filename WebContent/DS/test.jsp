<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@page session="true"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.sql.*"%>
<%@page import="post.PostDao"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>upload</title>
</head>
<body>
	<form action="file_upload.jsp" method="post" enctype="multipart/form-data">
		파일: <input type="file" name="file1" />
		 ${sessionScope.post.pk}<input
						type="text" name="name" value="${sessionScope.post.pk}" />
                <br />
		파일: <input type="file" name="file2" /> <br />
		파일: <input type="file" name="file3" /> <br />
		<input type="submit" value="업로드" />
	</form>
	<br />
	<a href="file_download.jsp">다운로드페이지</a>
</body>
</html>