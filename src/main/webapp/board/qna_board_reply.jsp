<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC게시판</title>
<link rel="stylesheet" href="/board_proj/board/css/style3.css">
</head>
<body>
${article }<br>${page }
	<section id="writeForm">
		<h2>게시판글등록</h2>
		<form action="boardReplyPro.do" method="post" name="boardForm">
			<input type="hidden" name="page" value="${page }" /> <input
				type="hidden" name="board_num" value="${article.board_num }">
			<input type="hidden" name="board_re_ref"
				value="${article.board_re_ref }"> <input type="hidden"
				name="board_re_lev" value="${article.board_re_lev }"> <input
				type="hidden" name="board_re_seq" value="${article.board_re_seq }">
			<table>
				<tr>
					<td class="td_left"><label for="board_name">글쓴이</label></td>
					<td class="td_right"><input type="text" name="board_name" id="board_name"/></td>
				</tr>
				<tr>
					<td class="td_left"><label for="board_pass">비밀번호</label></td>
					<td class="td_right"><input type="password" id="board_pass" name="board_pass"/></td>
				</tr>
				<tr>
					<td class="td_left"><label for="board_subject">제목</label></td>
					<td class="td_right"><input name="board_subject" type="text" id="board_subject"/></td>
				</tr>
				<tr>
					<td class="td_left"><label for="board_content">내용</label></td>
					<td><textarea id="board_content" name="board_content" cols="40" rows="15"></textarea></td>
				</tr>
			</table>
			<section id="commandCell">
				<input type="submit" value="답변글등록"/>&nbsp;&nbsp;
				<input type ="reset" value="다시작성"/>
			</section>
		</form>
	</section>

</body>
</html>