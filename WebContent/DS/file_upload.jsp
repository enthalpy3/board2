<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="fileup.FileDao"%>
<%@ page import="java.io.IOException" %>
<%@ page import="java.nio.file.Files" %>
<%@ page import="java.nio.file.Paths" %>

<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>upload</title>
</head>
<body>
	<%
		String directory = application.getRealPath("/upload/");
		int maxSize = 1024 * 1024 * 100;
		String encoding = "utf-8";
		MultipartRequest MultipartRequest = new MultipartRequest(request, directory, maxSize, encoding,
				new DefaultFileRenamePolicy());
		String fileName = MultipartRequest.getOriginalFileName("file");
		String fileReal = MultipartRequest.getFilesystemName("file");
		
		new FileDao().uploadFile(fileName,fileReal);
		
		out.write("파일명: "+ fileName + "<br>");
		out.write("실제 파일명: "+ fileReal + "<br>");
	%>
</body>
</html>