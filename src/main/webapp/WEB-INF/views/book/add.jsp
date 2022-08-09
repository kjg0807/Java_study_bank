<%@page import="com.naver.start.bankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
BankBookDTO bankMembersDTO = (BankBookDTO) request.getAttribute("add");
%>
<body>
	<h1>Product Insert</h1>
	<form action="./add" method="post">
		<table>
			<tr>
				<td>BookNum</td>
				<td>
					<input type="text" name="booknum" placeholder="Booknum" onfocus="this.placeholder=''" onblur="this.placeholder='Booknum'">
				</td>
			</tr>
			<tr>
				<td>BookName</td>
				<td>
					<input type="text" name="bookname" placeholder="Bookname" onfocus="this.placeholder=''" onblur="this.placeholder='Bookname'">
				</td>
			</tr>
			<tr>
				<td>BookRate</td>
				<td>
					<input type="text" name="bookrate" placeholder="Bookrate" onfocus="this.placeholder=''" onblur="this.placeholder='Bookrate'">
				</td>
			</tr>
			<tr>
				<td>BookSale</td>
				<td>
					<input type="text" name="booksale" placeholder="Booksale" onfocus="this.placeholder=''" onblur="this.placeholder='Booksale'">
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="Insert">
				</td>
				<td>
					<input type="reset" value="reset">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>