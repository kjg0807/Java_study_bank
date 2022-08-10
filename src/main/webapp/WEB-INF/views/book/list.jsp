<%@page import="com.naver.start.bankBook.BankBookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
//스크립 틀릿 <% java code 작성 % >
//html <%= % >
ArrayList<BankBookDTO> ar = (ArrayList<BankBookDTO>) request.getAttribute("list");
%>
<body>
	<h1>BankBook List</h1>
	<!-- /bankbook/list -->
	<table border="1" cellpadding="5" cellspacing="0">
		<thead>
			<tr>
				<th>Name</th>
				<th>Rate</th>
			</tr>
			<tr>
				<td>Name1</td>
				<td>0.012</td>
			</tr>
			<tr>
				<td>Name2</td>
				<td>3.14</td>
			</tr>
		</thead>
		<tbody>
			<%
			for (BankBookDTO bankBookDTO : ar)
			{
			%>
			<tr>
				<td>
					<a href="./detail?booknum=<%=bankBookDTO.getBookNum()%>">
						<%=bankBookDTO.getBookName()%>
					</a>
				</td>
				<!-- name -->
				<td><%=bankBookDTO.getBookRate()%></td>
				<!-- rate -->
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<form action="/list" method="post">
		<h3>list</h3>
		<a href="/test_index.html>">Index Page</a>
		<br>
		<a href="./detail">BankBook Detail</a>		
	</form>
</body>
</html>