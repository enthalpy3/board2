<%@page import="java.util.Enumeration"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="file.FileDao"%>
<%@ page import="java.io.IOException"%>
<%@ page import="java.nio.file.Files"%>

<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>

	<%
		String directory = "E:/jsp/upload/";
		int maxSize = 1024 * 1024 * 100;
		String encoding = "UTF-8";
		MultipartRequest MultipartRequest = new MultipartRequest(request, directory, maxSize, encoding,
				new DefaultFileRenamePolicy());

		Enumeration fileNames = MultipartRequest.getFileNames();
		while (fileNames.hasMoreElements()) {
			String parameter = (String) fileNames.nextElement();
			String fileName = MultipartRequest.getOriginalFileName(parameter);
			String fileReal = MultipartRequest.getFilesystemName(parameter);

			if(fileName == null) continue;
			//4개의 확장자만 업로드 된다.
			if (!fileName.endsWith(".txt") && !fileName.endsWith(".hwp") && !fileName.endsWith(".pdf")
					&& !fileName.endsWith(".xls")) {
				File file = new File(directory + fileReal);
				file.delete();
				out.write("업로드할 수 없는 확장자 입니다."+"<br />");
			} else {
				new FileDao().uploadFile(fileName, fileReal);
				out.write("파일명: " + fileName + "<br>");
				out.write("실제 파일명: " + fileReal + "<br>");
			}
		}
	%>