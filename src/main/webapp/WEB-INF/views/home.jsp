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
<a href="./member/login">Login</a>
<a href="./member/join">Join</a>
<a href="./member/search">Search</a>
<a href="./member/list">List</a>
<br>
<a href="./book/list">List</a>
<a href="./book/detail?bookNum=1">Detail</a>
<br>
<a href="./book/add">Add Page</a>