<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>	

	<P>The time on the server is ${serverTime}.</P>
</body>
</html>
Member:
<c:if test="${member == null}">
	<!-- empty member -->
	<a href="./member/login">Login</a>
	<a href="./member/join">Join</a>
</c:if>
<c:if test="${member != null }">
	<!-- not empty member -->
	<a href="#">Logout</a>
	<a href="#">My Page</a>
</c:if>

<a href="./member/search">Search</a>
<br>
<br>
Book:
<a href="./book/list">List</a>
<a href="./book/add">Add</a>