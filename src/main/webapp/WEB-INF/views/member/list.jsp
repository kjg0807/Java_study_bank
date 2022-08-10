<%@page import="java.util.ArrayList"%>
<%@page import="com.naver.start.bankMember.BankMembersDTO"%>
<%@page import="com.naver.start.bankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
ArrayList<BankMembersDTO> ar = (ArrayList<BankMembersDTO>) request.getAttribute("list");
%>
<body>
	<h1>Member List Page</h1>
	<form action="./list" method="post">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (BankMembersDTO bankMembersDTO : ar)
			{
			%>
			<tr>
				<td><%=bankMembersDTO.getUserid()%></td>
				<td><%=bankMembersDTO.getName()%></td>
				<td><%=bankMembersDTO.getEmail()%></td>
				<td><%=bankMembersDTO.getPhone()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</form>
</body>
</html>