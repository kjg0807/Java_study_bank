<%@page import="com.naver.start.bankMember.BankMembersDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>

	<form action="./search.naver" method="post">
	
		<section class="col-lg-6 container-fluid mt-4">
			<div class="mb-3">
				<label>Search Name</label>
				<input type="text" class="form-control" name="search" aria-describedby="emailHelp">
				<div id="emailHelp" class="form-text">Input Name</div>
			</div>			
			<button type="submit" class="btn btn-primary">Search</button>
		</section>
	</form>

	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>