<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous"
>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"
></script>
<body>
	<c:import url="../template/header.jsp"></c:import>

	<form action="./mypage.naver" method="post">
		<section class="container-fluid col-lg-6">
			<div class="row mt-3">
				<table class="table table-hover">
					<tr>
						<td>ID</td>
						<td>Name</td>
						<td>Email</td>
						<td>Phone</td>
					</tr>
					<tr>
						<td>${dto.userid }</td>
						<td>${dto.name }</td>
						<td>${dto.email }</td>
						<td>${dto.phone }</td>
					</tr>
				</table>
			</div>
			<div class="row mt-3">
				<table class="table table-hover">
					<tr>
						<th>AccountNum</th>
						<th>Title</th>
						<th>Date</th>
					</tr>
					<c:forEach items="${dto.bankAccountDTOs}" var="dto">
						<tr>
							<td>${pageScope.dto.accountNum}</td>
							<td>${dto.bankBookDTO.bookName}</td>
							<td>${dto.accountDate}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="row mt-3">
				<img alt="이미지안떠" src="../resources/upload/member/${dto.bankMembersFileDTO.fileName}">
			</div>
			<br>
			<div>
				<c:forEach items="${member.roleDTOs}" var="roleDTO">
					<div>${roleDTO.roleNum},${roleDTO.roleName}</div>
				</c:forEach>
				<h1>you are ${member.roleDTOs.get(0).roleName}</h1>
				<h1>you are ${member.roleDTOs["0"].roleName}</h1>
			</div>

		</section>
	</form>

	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>