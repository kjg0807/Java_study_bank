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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<style>
form {
	margin-top: 50px;
}
</style>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-6">
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">Num</th>
					<th scope="col">Name</th>
					<th scope="col">Rate</th>
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
	</section>
	<!-- <form action="./list.naver" method="post" align="center">
		<h4>
			<a href="../">Home Page</a>
		</h4>
		<br>
		<h4>
			<a href="../member/login.naver">Login Page</a>
		</h4>
	</form> -->

	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>