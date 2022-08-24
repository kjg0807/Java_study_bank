<%@page import="com.naver.start.bankBook.BankBookDTO"%>
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
		<table class="table table-hover">
			<tr>
				<th>Num</th>
				<th>Name</th>
				<th>Rate</th>
				<th>Sale</th>
			</tr>
			<tr>
				<td>${requestScope.dto.getBookNum() }</td>
				<td>${requestScope.dto.bookName }</td>
				<td>${dto.bookRate }</td>
				<td>${dto.bookSale }</td>
				<!-- <td><%--<%=bankBookDTO.getBookNum()%></td>
			<td><%=bankBookDTO.getBookName()%></td>
			<td><%=bankBookDTO.getBookRate()%> --%></td>  -->
			</tr>
		</table>
	</section>
	<form action="/detail.naver" method="post" align="center">
		<h3>detail</h3>
		<a href="./list.naver">List Page</a>
		<br>
		<a href="../">Home Page</a>
		<br>
		<a href="./modify.naver?bookNum=${dto.bookNum }">Modify Page</a>
		<a href="./delete.naver?bookNum=${dto.bookNum}">Delete Page</a>
		<br>
		<!-- 로그인 되있는 사람만 보이게 하기 -->
		<c:if test="${member != null}">
			<a href="../account/add.naver?bookNum=${dto.bookNum }">Account Add</a>
		</c:if>
	</form>
	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>