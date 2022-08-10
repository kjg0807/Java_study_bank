<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>

<body>
	<h1>Login Page</h1>
	<!-- 로그인 - 아이디, 패스워드, 로그인 버튼 -->
	<form action="/login" method="post">
		<!-- action-절대경로: /test/member/Login -->
		아이디: <input type="text" name="id" placeholder="ID 입력" onfocus="this.placeholder=''" onblur="this.placeholder='ID 입력'"> 
		<br> 
		비밀번호: <input type="text" name="pwd" placeholder="PWD 입력" onfocus="this.placeholder=''" onblur="this.placeholder='PWD 입력'">
		<p>
			아이디 저장 <input type="checkbox">
		</p>		
		<input type="submit" value="로그인"> 
		<input type="reset" value="초기화">
		<hr>		 
		<a href="./home.jsp>">Home</a>
		<!-- <a href="/study_index.html">인덱스 페이지</a>  -->
		<!--<a href="./study_index.html">인덱스</a>-->
		<br> <br> 
		<a href="https://youtube.com"><img src="/image/youtube.jpg"></a>
	</form>
</body>
</html>