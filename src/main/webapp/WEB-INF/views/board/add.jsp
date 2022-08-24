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
		<h1>${board}_Add_Page</h1>
		<form action="./add.naver" method="post">
			<table class="table table-hover">
				<div class="mb-3">
					<label>Title</label>
					<input type="text" class="form-control" name="title" aria-describedby="emailHelp">
					<div class="form-text">Input Title</div>
				</div>
				<div class="mb-3">
					<label>Contents</label>
					<input type="text" class="form-control" name="contents" aria-describedby="emailHelp">
					<div class="form-text">Input Contents</div>
				</div>
				<button type="submit" class="btn btn-primary">Writing</button>
			</table>
		</form>
	</section>
</body>
</html>