<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="fileup.FileDao"%>
<%@ page import="fileup.FileDTOInfo"%>

<%@ page import="java.io.File"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>download</title>
</head>
<body>
	<%
		ArrayList<FileDTOInfo> fileList = new FileDao().getList();
		for (FileDTOInfo file : fileList) {
			out.write("<a href=\"" + request.getContextPath() + "/downloadAction?file="
					+ java.net.URLEncoder.encode(file.getFileReal(), "UTF-8") + "\">" + file.getFileName()
					+ "(다운로드 횟수: " + file.getDownloadCount() + ")</a><br>");

		}
	%>
</body>
</html>