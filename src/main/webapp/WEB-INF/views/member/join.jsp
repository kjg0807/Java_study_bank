<%@page import="com.naver.start.bankMember.BankMembersDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</head>
<style>
form {
	margin-top: 50px;
	text-align: center;
}
</style>
<body>
	<c:import url="../template/header.jsp"></c:import>

	<form action="./join.naver" method="post" enctype="multipart/form-data">

		<section class="col-lg-6 container-fluid mt-4">
			<div class="row">
				<div class="mb-3">
					<label class="form-label">ID</label>
					<input type="text" class="form-control" name="userid" aria-describedby="emailHelp" placeholder="ID Input" onfocus="this.placeholder=''" onblur="this.placeholder='ID Input'">
				</div>
				<div class="mb-3">
					<label class="form-label">Password</label>
					<input type="password" class="form-control" name="pwd" placeholder="Password Input" onfocus="this.placeholder=''" onblur="this.placeholder='Password Input'">
				</div>
				<div class="mb-3">
					<label class="form-label">Name</label>
					<input type="text" class="form-control" name="name" aria-describedby="emailHelp" placeholder="Name Input" onfocus="this.placeholder=''" onblur="this.placeholder='Name Input'">
				</div>
				<div class="mb-3">
					<label class="form-label">Email</label>
					<input type="text" class="form-control" name="email" aria-describedby="emailHelp" placeholder="Eamil Input" onfocus="this.placeholder=''" onblur="this.placeholder='Eamil Input'">
				</div>
				<div class="mb-3">
					<label class="form-label">Phone</label>
					<input type="text" class="form-control" name="phone" aria-describedby="emailHelp" placeholder="Phone Input" onfocus="this.placeholder=''" onblur="this.placeholder='Phone Input'">
				</div>
				<div class="mb-3">
					<label for="files" class="form-label">Image</label>
					<input type="file" class="form-control" id="files" name="photo" aria-describedby="emailHelp" placeholder="Phone Input" onfocus="this.placeholder=''" onblur="this.placeholder='Phone Input'">
				</div>
				<button type="submit" class="btn btn-primary">Sign Up</button>
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