<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
	<h2>글작성자 정보</h2>
	<ul class="user_detail">
		<li>아이디 : ${memberList.id} </li>
		<li>전공 : ${memberList.major}</li>
		<li>나이 : ${memberList.age} </li>
		<li>이메일 : ${memberList.email}</li>
	</ul>
	
	<a href="BoardFreetalk">자유게시판으로</a>
	<a href="BoardEvaluation">강의평가로</a>
</body>
</html>