<%@page import="com.naver.start.bankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Detail</h1>
	<table border="1" cellpadding="5" cellspacing="0">
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
	<form action="/detail.naver" method="post">
		<h3>detail</h3>
		<a href="./list.naver">List Page</a>
		<br>
		<a href="../">Home Page</a>
		<br>
		<a href="./modify.naver?bookNum=${dto.bookNum }">Modify Page</a>
		<a href="./delete.naver?bookNum=${dto.bookNum }">Delete Page</a>
		<br>
		<!-- 로그인 되있는 사람만 보이게 하기 -->
		<c:if test="${member != null}">
			<a href="../account/add.naver?bookNum=${dto.bookNum }">가입하기</a>
		</c:if>
	</form>
</body>
</html>