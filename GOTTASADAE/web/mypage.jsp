<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>가라사대</title>
<script>
	function confirm_pw() {
		if (document.MemberModify.pw.value != document.MemberModify.pw_check.value) {
			alert("비밀번호를 정확하게 입력하세요.");
			return false;
		}
	}

	function confirm_quit_pw() {
		if (document.MemberModify.pw.value != document.MemberQuit.quit_pw.value) {
			alert("비밀번호가 일치하지 않습니다.");
			return false;
		} else {
			alert("회원탈퇴를 진행합니다.")
			return true;
		}
	}
</script>
</head>
<body>
<div id="mypage" class="container form_base">
	<div>
		<h2>
		<c:if test="${sessionScope.sessionID eq 'admin'}">ADMIN 계정 정보수정</c:if>
		<c:if test="${sessionScope.sessionID ne 'admin'}">회원수정 </c:if>
		</h2>
		<form name="MemberModify" action="MemberModify" method="post" enctype="multipart/form-data"
			onsubmit="return confirm_pw(); ">
			<ul>
				<li><span>아이디</span> <input type="text" name="id" id="id"
					class="input_readonly" value="${memberList.id}" readonly
					maxlength="50"></li>
				<li><span>비밀번호</span> <input type="password" name="pw" id="pw"
					class="input_readonly" readonly value="${memberList.password}"
					maxlength="50"></li>
				<li><span>이름</span> <input type="text" name="name" id="name" value="${memberList.name}"
					maxlength="20"></li>
				<li><span>학과</span> <input type="text" name="major" id="major" value="${memberList.major}"
					maxlength="50"></li>
					
				<li><span>생년월일</span> <select name="birthyy">
						<option value="${memberList.birthyy}">${memberList.birthyy}</option>
						<option value="">----</option>
						<option value="1980">1980</option>
						<option value="1981">1981</option>
						<option value="1982">1982</option>
						<option value="1983">1983</option>
						<option value="1984">1984</option>
						<option value="1985">1985</option>
						<option value="1986">1986</option>
						<option value="1987">1987</option>
						<option value="1988">1988</option>
						<option value="1989">1989</option>
						<option value="1990">1990</option>
						<option value="1991">1991</option>
						<option value="1992">1992</option>
						<option value="1993">1993</option>
						<option value="1994">1994</option>
						<option value="1995">1995</option>
						<option value="1996">1996</option>
						<option value="1997">1997</option>
						<option value="1998">1998</option>
						<option value="2000">2000</option>
						<option value="2001">2001</option>
						<option value="2002">2002</option>
						<option value="2003">2003</option>
						<option value="2004">2004</option>
						<option value="2005">2005</option>
						<option value="2006">2006</option>
						<option value="2007">2007</option>
						<option value="2008">2008</option>
						<option value="2009">2009</option>
						<option value="2010">2010</option>
				</select> <select name="birthmm">
						<option value="${memberList.birthmm}">${memberList.birthmm}</option>
						<option value="">----</option>
						<option value="01">1</option>
						<option value="02">2</option>
						<option value="03">3</option>
						<option value="04">4</option>
						<option value="05">5</option>
						<option value="06">6</option>
						<option value="07">7</option>
						<option value="08">8</option>
						<option value="09">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
				</select> <select name="birthdd">
						<option value="${memberList.birthdd}">${memberList.birthdd}</option>
						<option value="">----</option>
						<option value="01">1</option>
						<option value="02">2</option>
						<option value="03">3</option>
						<option value="04">4</option>
						<option value="05">5</option>
						<option value="06">6</option>
						<option value="07">7</option>
						<option value="08">8</option>
						<option value="09">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
						<option value="24">24</option>
						<option value="25">25</option>
						<option value="26">26</option>
						<option value="27">27</option>
						<option value="28">28</option>
						<option value="29">29</option>
						<option value="30">30</option>
						<option value="31">31</option>
				</select></li>
				<li><span>성별</span> <input type="text" name="gender"
					id="gender" class="input_readonly" readonly
					value="${memberList.gender}" maxlength="20"></li>
				<li><span>핸드폰</span> 
				<input type="text" style="width: 200px;" name="phone"
					value="${memberList.phone}" maxlength="11"></li>
				<li><span>이메일</span> <input type="email" name="email"
					id="email" value="${memberList.email}" autofocus maxlength="50">
				</li>
				<li><span>주소</span> <input type="text" name="address"
					id="address" value="${memberList.address}" autofocus maxlength="50">
				</li>
				<li><input type="submit" value="정보수정"></li>
			</ul>
		</form>
	</div>
	<c:if test="${sessionScope.id ne 'admin'}">
	<div>
		<h2>회원탈퇴</h2>
		<form name="MemberQuit" action="MemberQuit" method="post"
			onsubmit="return confirm_quit_pw();">
			<ul>
				<li><p>회원탈퇴를 위해 비밀번호를 입력해주세요.</p> <input type="password"
					name="quit_pw" id="quit_pw" maxlength="50"></li>
				<li><input type="submit" value="회원탈퇴"></li>
			</ul>
		</form>
	</div>
	</c:if>
</div>
</body>
</html>
