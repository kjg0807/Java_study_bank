<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<body>
	<c:import url="../template/header.jsp"></c:import>

	<form action="./mypage.naver" method="post">
		<p>ID: ${dto.userid }</p>
		<p>Name: ${dto.name }</p>
		<p>Email: ${dto.email }</p>
		<p>Phone: ${dto.phone }</p>

		<table class="table table-hover">
			<tr>
				<th>Account Num</th>
				<th>BookName</th>
				<th>Date</th>
			</tr>
			<c:forEach items="${dto.bankAccountDTOs }" var="dto">
				<p>${dto.accountNum }</p>
				<p>${dto.bankBookDTO.bookName }</p>
				<p>${dto.accountDate }</p>
			</c:forEach>
		</table>
	</form>

	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>