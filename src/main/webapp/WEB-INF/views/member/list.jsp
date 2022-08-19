<%@page import="java.util.ArrayList"%>
<%@page import="com.naver.start.bankMember.BankMembersDTO"%>
<%@page import="com.naver.start.bankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- HTML반복문 사용하기 위한 선언 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<body>
	<table class="table table-hover">
		<c:import url="../template/header.jsp"></c:import>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Phone</th>
		</tr>

		<c:forEach items="${requestScope.list }" var="dto">
			<tr>
				<td>${pageScope.dto.userid }</td>
				<td>${pageScope.dto.name }</td>
				<td>${pageScope.dto.email }</td>
				<td>${pageScope.dto.phone }</td>
			</tr>
		</c:forEach>
	</table>
	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>