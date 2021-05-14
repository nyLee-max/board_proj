<%@page import="board_proj.ds.JndiDs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
방가~~~!
<%=JndiDs.getConnection() %>

<a href="boardWriterForm.do">게시판 글쓰기</a>

</body>
</html>