<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<style>
.a {
	float: right;
}
</style>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-6">
		<table class="table table-hover">
			<h1>${board}_Detail_Page</h1>
			<nav class="a">
				<button type="submit" class="btn btn-primary">
					<a href="./update.naver?num=${boardDTO.num}" color="white">Update Page</a>
				</button>
			</nav>
			<thead>
				<tr>
					<th>Num</th>
					<th>Title</th>
					<th>Writer</th>
					<th>Contents</th>
					<th>Date</th>
					<th>Hit</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${boardDTO.num }</td>
					<td>${boardDTO.title }</td>
					<td>${boardDTO.writer }</td>
					<td>${boardDTO.contents }</td>
					<td>${boardDTO.regDate }</td>
					<td>${boardDTO.hit }</td>
				</tr>
			</tbody>
		</table>
		<div class="row">
			<c:forEach items="${boardDTO.boardFileDTOs}" var="file">
				<p>
					<a href="../resources/upload/${board}/${file.fileName}">${file.oriName}</a>
				</p>
			</c:forEach>
		</div>
		<div class="row">
			<a class="btn btn-danger" href="./reply.naver?num=${boardDTO.num}">Reply</a>
		</div>
	</section>
	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>