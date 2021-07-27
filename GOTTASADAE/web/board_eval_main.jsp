<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>가라사대</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
	function write_btn(){
		var sessionId = '${sessionScope.sessionID}';
		
		console.log("sessionId : " + sessionId );
		
		if ( sessionId == "" ) {
			alert("로그인 후 이용하세요.");
			//location.href="login_main.jsp";
		} 
		else {
			location.href="board_eval_write.jsp";
		}
	}
</script>
</head>
<body>
<div id="evaluation_board" class="container board_base">
	<h2>강의평가</h2>
	<ul>
		<li>글번호</li>
		<li style="width: 400px;">글제목</li>
		<li>작성자</li>
		<li>작성일자</li>
		<li>조회수</li>
	</ul>
	<c:forEach var="result" items="${evalBoardList}">
		<ul style="margin-top: -17px;">
			<li>${result.eval_num}</li>
			<li style="width: 400px;"><a
				href="BoardEvalContents?eval_num=${result.free_num}&page=${paging.page}"
				style="color: #f18c8e"> ${result.free_subject} </a></li>
			<li class="eval_id">
				<a href="BoardEvalUserDetail?eval_id=${result.eval_id}" style="color:#bb1542">${result.eval_id}</a>
			</li>
			<li>${result.eval_date}</li>	
			<li>${result.eval_count}</li>
		</ul>
	</c:forEach>

	<c:if test="${paging.page<=1}">
		[이전]&nbsp;
	</c:if>

	<c:if test="${paging.page>1}">
		<a href="BoardEvaluation?page=${paging.page-1}">[이전]</a>&nbsp;
	</c:if>

	<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i"
		step="1">
		<c:choose>
			<c:when test="${i eq paging.page}">
				<span style="color: #ff8260;">${i}</span>
			</c:when>
			<c:otherwise>
				<a href="BoardEvaluation?page=${i}">${i}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<c:if test="${paging.page>=paging.maxPage}">
		[다음]
	</c:if>

	<c:if test="${paging.page<paging.maxPage}">
		<a href="BoardEvaluation?page=${paging.page+1}">[다음]</a>
	</c:if>
	
		<div class="boardBot">
			<a href="javascript:write_btn();">글쓰기</a>
		</div>
</div>
</body>
</html>