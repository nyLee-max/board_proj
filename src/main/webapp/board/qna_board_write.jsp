<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
<link rel="stylesheet" href="/board_proj/board/css/style.css">
</head>
<body>
	<form action="boardWriterPro.do" method="post"
		enctype="multipart/form-data" name="boardform">
		<table>
			<tr>
				<td class="td_left"><label for="board_name">글쓴이</label></td>
				<td class="td_right"><input type="text" name="board_name"
					id="board_name" required="required"></td>
			</tr>
			<tr>
				<td class="td_left"><label for="board_pass">비밀번호</label></td>
				<td class="td_right"><input type="password" name="board_pass"
				type="password" id="board_pass" required="required"/></td>
			</tr>
			<tr>
				<td class="td_left"><label for="board_subject">제목</label></td>
				<td class="td_right"><input name="board_subject" type="text" id="board_subject" required/></td>
			</tr>
			<tr>
				<td class="td_left"><label for="board_content">내용</label></td>
				<td><textarea id="board_content" name="board_content" cols="40" rows="15" required></textarea></td>
			</tr>
			<tr>
			<td class="td_left"><label for="board_file">파일 첨부</label></td>
			<td class="td_right"><input name="board_file" type="file" id="board_file" required/></td>
			</tr>
		</table>
		<section id="commandCell">
			<input type="submit" value="등록">&nbsp;&nbsp;
			<input type="reset" value="다시쓰기"/>
		</section>

	</form>
</body>
</html>