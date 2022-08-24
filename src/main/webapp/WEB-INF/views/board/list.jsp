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
	<section class="container-fluid col-lg-6">
		<form action="./list.naver" method="post">
			<table class="table table-hover">
				<h1>${board} List Page</h1>
				<thead>
					<tr>
						<th>Num</th>
						<th>Title</th>
						<th>Writer</th>
						<th>Date</th>
						<th>Hit</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="dto">
						<tr>
							<td>${dto.num }</td>
							<td>
								<a href="./detail.naver?num=${dto.num }">${dto.title }</a>
							</td>
							<td>${dto.writer }</td>
							<td>${dto.regDate }</td>
							<td>${dto.hit }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<button type="submit" class="btn btn-primary">Writing Page</button>
		</form>
	</section>

	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>