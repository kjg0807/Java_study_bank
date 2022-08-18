<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
</head>
<style>
.f {
	top: 50%;
	margin-top: 220px;
}
</style>
<body>
	<form align="center" class="f">
		<h1>Hello world!</h1>
		<h3>Add VsCode</h3>

		<P>The time on the server is ${serverTime}.</P>
		<c:if test="${member == null}">
			<!-- empty member -->
	Member:
	<a href="./member/login.naver">Login</a>
			<a href="./member/join.naver">Join</a>
		</c:if>
		<c:if test="${member != null }">
			<!-- not empty member -->
	Member:
	<h3>${member.name}님안녕하세요!</h3>
			<a href="./member/logout.naver">Logout</a>
			<a href="#">My Page</a>
		</c:if>

		<a href="./member/search.naver">Search</a>
		<br> <br> Book:
		<a href="./book/list.naver">List</a>
		<a href="./book/add.naver">Add</a>
		<br> <br>
		<a href="https:youtube.com">
			<img src="../resources/image/you.png" width="250px" height="200px">
		</a>
	</form>
</body>
</html>