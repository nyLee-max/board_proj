<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
</head>
<body>
<body>
	<%-- ${page }
<br>
${article } --%>
	<section>
		제목 : ${article.board_subject} 첨부 파일 :
		<c:if test="${article.board_file ne null }">
			<a href="fileDown.do?downFile=${article.board_file }">${article.board_file }</a>
		</c:if>
		<article id="articleContentArea">${article.board_content }</article>
	</section>
	<section>
		<a
			href="boardReplyForm.do?board_num=${article.board_num }&page=${page}">[답변]</a>
		<a href="boardModifyForm.do?board_num=${article.board_num }&page=${page}">[수정]</a>
		<a
			href="boardDeleteForm.do?board_num=${article.board_num }&page=${page}">[삭제]</a>
		<a href="boardList.do?page=${page}">[목록]</a>
	</section>
</body>

</html>