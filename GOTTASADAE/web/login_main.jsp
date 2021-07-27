<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>가라사대</title>
</head>
<body>
<div id="login_main" class="container form_base" >
	<h2>Login page</h2>	
 	<form name="LoginForm" action="login" method="post" onsubmit="return checkLogin();">
 		<ul>
			<li>
				<span>ID </span>
				<input type="text" name="id" id="id" autofocus placeholder="아이디를 입력하세요" maxlength="20">
			</li>
			<li>
				<span>PW </span>
				<input type="password" name="pw" id="pw" autofocus placeholder="비밀번호를 입력하세요" maxlength="20">
			</li>
			<li><input type="submit" value="로그인"></li>
		</ul>
 	</form>
 </div>
</body>
</html>	