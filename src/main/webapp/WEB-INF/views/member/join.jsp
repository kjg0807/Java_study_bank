<%@page import="com.naver.start.bankMember.BankMembersDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<style>
* {
	margin-left: 12%;
	margin-top: 5%;
}
</style>
<%
BankMembersDTO bankMembersDTO = (BankMembersDTO) request.getAttribute("join");
%>
<body>
	<h1>Join Page</h1>
	<!-- 회원가입(DB에 넣는 것) - 아이디, 비밀번호, 이름, 이메일, 전화번호 -->
	<form action="./join.naver" method="post">
		<table align="center">
			<caption>
				<b>회원가입 창</b>
			</caption>
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="userid" placeholder="ID입력" onfocus="this.placeholder=''" onblur="this.placeholder='ID 입력'"
						style="width: 100px;"
					>
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="text" name="pwd" placeholder="PWD입력" onfocus="this.placeholder=''" onblur="this.placeholder='PWD 입력'"
						style="width: 100px;"
					>
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="name" placeholder="이름 입력" onfocus="this.placeholder=''" onblur="this.placeholder='이름 입력'"
						style="width: 100px;"
					>
				</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>
					<input type="text" name="email" placeholder="이메일 입력" onfocus="this.placeholder=''" onblur="this.placeholder='이메일 입력'"
						style="width: 100px;"
					>
				</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>
					<input type="text" name="phone" placeholder="전화번호 입력" onfocus="this.placeholder=''" onblur="this.placeholder='전화번호 입력'"
						style="width: 100px;"
					>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="회원가입">
				</td>
				<td>
					<input type="reset" value="초기화">
				</td>
			</tr>
		</table>
		<a href="/study_index.html">Index Page</a> <br> <a href="https://youtube.com"> <img src="/image/youtube.jpg">
		</a>
	</form>
</body>
</html>