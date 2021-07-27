<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>가라사대</title>
<script type="text/javascript">
	function member_delete_comfirm() {
		var c = confirm('정말로 해당 회원을 삭제하시겠습니까?');
		var id = '${memberList.id}';
		if (c) {
			console.log("yes 선택 : " + id);
			location.href = "AdminMemberQuit?id=${memberList.id}";
		} else {
			console.log("no 선택");
		}
	}
</script>
</head>
<body>
<div id="admin_modify" class="container form_base">
	<div>
		<h2>관리자용 회원수정<br>(아이디를 제외한 모든 정보 수정 가능)</h2>
		<form name="AdminMemberModify" action="AdminMemberModifySummit"
			method="post" enctype="multipart/form-data">
			<ul>
				<li><span>아이디</span> <input type="text" name="id" id="id"
					class="input_readonly" value="${memberList.id}" readonly
					maxlength="50"></li>
				<li><span>비밀번호</span> <input type="password" name="pw" id="pw"
					value="${memberList.password}" maxlength="50"></li>
				<li><span>이름</span> <input type="text" name="name" id="name"
					value="${memberList.name}" maxlength="20"></li>
				<li><span>학과</span> <input type="text" name="major" id="major"
					value="${memberList.major}" maxlength="50"></li>
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
					id="gender" value="${memberList.gender}" maxlength="20"></li>
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
	
	<div>
		<h2>회원제명</h2>
		<a href="javascript:member_delete_comfirm();">해당 회원을 추방합니다.</a>
	</div>
</div>
</body>
</html>
