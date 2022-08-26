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
<body>
	<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-6">
		<h1>${board}_Update_Page</h1>
		<form action="./update.naver" method="post">
			<table class="table table-hover">
				<div class="mb-3">
					<label>Title</label>
					<input type="text" class="form-control" name="title" aria-describedby="emailHelp" value="${boardDTO.title}">
					<div class="form-text">Input Title</div>
				</div>
				<div class="mb-3">
					<label>Writer</label>
					<input type="text" class="form-control" name="writer" aria-describedby="emailHelp" value="${boardDTO.writer}" disabled>
					<div class="form-text">Input Writer</div>
				</div>
				<div class="mb-3">
					<label>Contents</label>
					<textarea rows="5" cols="20" class="form-control" name="contents">${boardDTO.contents}</textarea>
					<!-- <input type="text" class="form-control" name="writer" aria-describedby="emailHelp"> -->
					<div class="form-text">Input Contents</div>
				</div>
			</table>
			<button type="submit" class="btn btn-primary">Update</button>
		</form>
	</section>
	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>