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
	<h1>Add Page</h1>
	<form action="./add" method="post">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="bookName" placeholder="Bookname" onfocus="this.placeholder=''" onblur="this.placeholder='Bookname'"></td>
			</tr>
			<tr>
				<td>Rate</td>
				<td><input type="text" name="bookRate" placeholder="Bookrate" onfocus="this.placeholder=''" onblur="this.placeholder='Bookrate'"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Insert"></td>
				<td><input type="reset" value="reset"></td>
			</tr>
		</table>
	</form>
</body>
</html>