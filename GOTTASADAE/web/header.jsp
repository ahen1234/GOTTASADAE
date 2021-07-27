<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가라사대</title>
<link rel="stylesheet" href="style.css" type="text/css">
<script type="text/javascript">
</script>
</head>
<body>
	<div class="top_container">
		<div id="top_menu">
			<div class="account">
				<ul>
					<li><a href="Main.jsp">HOME</a></li>
					<c:if test="${empty sessionScope.sessionID}">
						<li><a href="login_main.jsp">로그인</a></li>
						<li><a href="Join_form.jsp">회원가입</a></li>
					</c:if>
					<li><a href="board_freetalk_main.jsp">자유게시판</a></li>	
					<li><a href="board_eval_main.jsp">강의평가</a></li>
					<c:if test="${not empty sessionScope.sessionID}">
						<li><a href="mypage.jsp">마이페이지</a></li>
					</c:if>

					<c:if test="${sessionScope.sessionID eq 'admin'}">
						<li><a href="MemberList" style="padding-left: 13px;">회원관리(관리자전용)</a></li>
					</c:if>
					
					<c:if test="${not empty sessionScope.sessionID}">
						<li><a href="Logout?action=sessionID" class="top_login">로그아웃</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
	<div class="middle_container">
		<div id="middle_menu" class="r_width">
			<h1>
				<a href="Main.jsp"><img id="main_logo"
					src="img/toplogosample.png" style="width:100px;"></a>
			</h1>
			<div class="search">
			<input name="is_keyword" type="text" class="TopinputText" title="keyword" value=" 검색..." onfocus="if(this.value==' 검색...')this.value='';" onblur="if(this.value=='')this.value=' 검색...';" />
			<input type="image" src="img/empty.gif" alt="submit" title="submit" class="Topsearch" />		
			</div>
		</div>
	</div>
	<div class="gnb_container">
	</div>
</body>
</html>