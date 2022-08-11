<%@page import="com.naver.start.bankMember.BankMembersDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
BankMembersDTO bankMembersDTO = (BankMembersDTO) request.getAttribute("search");
%>
<body>
	<h1>Search Page</h1>
	<form action="search" method="post">
		<div>
			<input type="text" name="search">
		</div>
		<div>
			<input type="submit" value="Search">
			<input type="reset" value="reset">
		</div>
	</form>
</body>
</html>