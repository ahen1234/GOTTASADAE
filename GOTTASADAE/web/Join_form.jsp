<%@ include file="header.jsp" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>가라사대</title>
<script>
<!--
function id_check(){
	if (!document.JoinForm.id.value) {
		alert("아이디를 입력하세요.");
		return false;
	} else {
		 window.name = "parentForm";
         window.open("id_check_form.jsp",
                    "chkForm", "width=500, height=300, resizable = no, scrollbars = no")
	}
}
function input_id_check(){
	document.JoinForm.id_duplication.value = "id_uncheck";
}

-->
	

</script>
</head>
<body>
<div id="join_form" class="container form_base" >
	<h2>회원가입</h2>
	<form name="JoinForm" action="join" method="post" onsubmit="return checkValue();">
		<ul>
			<li>
				<span>아이디</span>
				<input type="text" name="id" id="id" onkeydown="input_id_check();" placeholder="아이디를 입력하세요." autofocus maxlength="20" >
				<!-- <input type="button" value="중복확인" onclick="id_check();" style="width: 70px;"> -->
				<input type="hidden" name="id_duplication" value="id_uncheck">
			</li>
			<li>
				<span>비밀번호</span>
				<input type="password" name="pw" id="pw" placeholder="비밀번호를 입력하세요" autofocus maxlength="20" >
			</li>
			<li>
				<span>비밀번호 확인</span>
				<input type="password" name="pw_check" id="pw_check" placeholder="비밀번호 확인" autofocus maxlength="20" >
			</li>
			<li>
				<span>이름</span>
				<input type="text" name="name" id="name" placeholder="이름을 입력하세요" autofocus maxlength="20" >
			</li>
			<li>
				<span>학과</span>
				<input type="text" name="major" id="major" placeholder="소속 학과를 입력하세요" autofocus maxlength="50" >
			</li>
			<li>
				<span>생년월일</span>
				<select name="birthyy">
                     <option value="">년</option>
                     <option value="1980" >1980</option>
                     <option value="1981" >1981</option>
                     <option value="1982" >1982</option>
                     <option value="1983" >1983</option>
                     <option value="1984" >1984</option>
                     <option value="1985" >1985</option>
                     <option value="1986" >1986</option>
                     <option value="1987" >1987</option>
                     <option value="1988" >1988</option>
                     <option value="1989" >1989</option>
                     <option value="1990" >1990</option>
                     <option value="1991" >1991</option>
                     <option value="1992" >1992</option>
                     <option value="1993" >1993</option>
                     <option value="1994" >1994</option>
                     <option value="1995" >1995</option>
                     <option value="1996" >1996</option>
                     <option value="1997" >1997</option>
                     <option value="1998" >1998</option>
                     <option value="2000" >2000</option>
                     <option value="2001" >2001</option>
                     <option value="2002" >2002</option>
                     <option value="2003" >2003</option>
                     <option value="2004" >2004</option>
                     <option value="2005" >2005</option>
                     <option value="2006" >2006</option>
                     <option value="2007" >2007</option>
                     <option value="2008" >2008</option>
                     <option value="2009" >2009</option>
                     <option value="2010" >2010</option>
                 </select>
				<select name="birthmm">
                     <option value="">월</option>
                     <option value="01" >1</option>
                     <option value="02" >2</option>
                     <option value="03" >3</option>
                     <option value="04" >4</option>
                     <option value="05" >5</option>
                     <option value="06" >6</option>
                     <option value="07" >7</option>
                     <option value="08" >8</option>
                     <option value="09" >9</option>
                     <option value="10" >10</option>
                     <option value="11" >11</option>
                     <option value="12" >12</option>
                 </select>
                <select name="birthdd">
                     <option value="">일</option>
                     <option value="01" >1</option>
                     <option value="02" >2</option>
                     <option value="03" >3</option>
                     <option value="04" >4</option>
                     <option value="05" >5</option>
                     <option value="06" >6</option>
                     <option value="07" >7</option>
                     <option value="08" >8</option>
                     <option value="09" >9</option>
                     <option value="10" >10</option>
                     <option value="11" >11</option>
                     <option value="12" >12</option>
                     <option value="13" >13</option>
                     <option value="14" >14</option>
                     <option value="15" >15</option>
                     <option value="16" >16</option>
                     <option value="17" >17</option>
                     <option value="18" >18</option>
                     <option value="19" >19</option>
                     <option value="20" >20</option>
                     <option value="21" >21</option>
                     <option value="22" >22</option>
                     <option value="23" >23</option>
                     <option value="24" >24</option>
                     <option value="25" >25</option>
                     <option value="26" >26</option>
                     <option value="27" >27</option>
                     <option value="28" >28</option>
                     <option value="29" >29</option>
                     <option value="30" >30</option>
                     <option value="31" >31</option>
                 </select>
			</li>
			<li>
				<span>성별</span>
				<span class="gender_index" style="width:200px;">
					<input type="radio" name="gender" value="남자">남자
					<input type="radio" name="gender" value="여자">여자
				</span>
			</li>
			<li>
				<span>핸드폰</span>                 
                 <input type="text" style="width: 200px;" name="phone" placeholder="하이픈(-) 없이 입력하세요" 
                 	autofocus maxlength="11">
			</li>
			<li>
				<span>이메일</span>
				<input type="email" name="email" id="email" placeholder="정확한 이메일을 입력하세요" autofocus maxlength="50" >
			</li>
			<li>
				<span>주소</span>
				<input type="text" name="address" id="address" placeholder="주소를 입력하세요(시, 도까지만)" autofocus maxlength="50" >
			</li>
			<li><input type="submit" value="회원가입"></li>
		</ul>
	</form>
</div>
</body>
</html>	