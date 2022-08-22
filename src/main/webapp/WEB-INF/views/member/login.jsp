<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<style>
form {
	margin-top: 50px;
}

.a {
	margin-left: 170px;
}
</style>
<body>
	<c:import url="../template/header.jsp"></c:import>

	<form action="./login.naver" method="post">

		<section class="col-lg-6 container-fluid mt-4">
			<div class="row">
				<div class="mb-3">
					<label>ID</label>
					<input type="text" class="form-control" name="userid" aria-describedby="emailHelp" placeholder="ID Input" onfocus="this.placeholder=''" onblur="this.placeholder='ID Input'">
					<div>We'll never share your ID with anyone else.</div>
				</div>
				<div class="mb-3">
					<label>Password</label>
					<input type="password" class="form-control" name="pwd" placeholder="Password Input" onfocus="this.placeholder=''" onblur="this.placeholder='Password Input'">
				</div>
				<div class="mb-3 form-check">
					<input type="checkbox" class="form-check-input" id="exampleCheck1">
					<label class="form-check-label" for="exampleCheck1">Check me out</label>
				</div>
				<button type="submit" class="btn btn-primary">Login</button>
			</div>
			<div class="row">
				<div class="mb-3 a">
					<a href="https://youtube.com">
						<img src="/resources/image/you.png">
					</a>
				</div>
			</div>
		</section>

	</form>
	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>