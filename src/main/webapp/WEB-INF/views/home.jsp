<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
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
<br>
<a href="./book/list">List</a>
<a href="./book/detail?bookNum=1">Detail</a>
<br>
<a href="./book/add">Product Insert</a>