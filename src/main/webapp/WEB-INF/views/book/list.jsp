<%@page import="com.naver.start.bankBook.BankBookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- HTML반복문 사용하기 위한 선언 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook List</h1>
	<!-- /bankbook/list -->
	<table border="1" cellpadding="5" cellspacing="0">
		<thead>
			<tr>
				<th>Num</th>
				<th>Name</th>
				<th>Rate</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.list}" var="dto">
				<tr>
					<td>${pageScope.dto.bookNum}</td>
					<td>
						<a href="./detail.naver?bookNum=${pageScope.dto.bookNum}">${pageScope.dto.bookName}</a>
					</td>
					<td>${pageScope.dto.bookRate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form action="./list.naver" method="post">
		<h3>list</h3>
		<a href="../">Home Page</a>
		<br>
		<a href="../member/login.naver">Login</a>
	</form>
</body>
</html>