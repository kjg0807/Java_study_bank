<%@page import="com.naver.start.bankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%--<%
BankBookDTO bankBookDTO = (BankBookDTO) request.getAttribute("dto");
--%>
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
	<form action="/detail" method="post">
		<h3>detail</h3>
		<a href="./list">List Page</a>
		<br>
		<a href="../">Home Page</a>
		<br>
		<a href="./modify?bookNum=${dto.bookNum }">Modify Page</a>
		<a href="./delete?bookNum=${dto.bookNum }">Delete Page</a>
		<br>		
	</form>
</body>
</html>