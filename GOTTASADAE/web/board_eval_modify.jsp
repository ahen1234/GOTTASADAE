<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>가라사대</title>
</head>
<body>
<div id="board_eval_write" class="container form_base">
	<h2>게시글 수정</h2>
	<form name="board_eval_modify" id="board_eval_modify" action = "BoardEvalModifyComplete?eval_num=${evalBoardList.eval_num}" method="post" 
			 enctype="multipart/form-data">
			<ul>
				<li>
					<span>작성자 : </span>
					<input type="text"  name="eval_id" id="eval_id" value="${sessionScope.sessionID}" readonly maxlength="50">				
				</li>
				<li>
					<span>제목 : </span>
					<input type="text" name="eval_subject" id="eval_subject" value="${evalBoardList.eval_subject}" autofocus maxlength="50" >				
				</li>
				<li>
					<span>내용 : </span><br><br>
					<textarea  name="eval_content" id ="eval_content" rows="10" cols="100">${evalBoardList.eval_content}</textarea>
				</li>
				<li>
					<span>첨부파일 : </span>
					<input type="file" name="eval_file" id="eval_file" value="${evalBoardList.eval_file}">
				</li>
				<li><input type="submit" value="업로드"></li>
			</ul>
		</form>
</div>
</body>
</html>
