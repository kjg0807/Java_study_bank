<%@page import="com.naver.start.bankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
//요청이 발생하면 생성, 응답이 나가면 소멸 : RequestScope
BankBookDTO bankBookDTO = (BankBookDTO) request.getAttribute("dto");
%>
<body>
	<h1>BankBook Detail</h1>
	<%
	if (bankBookDTO != null)
	{
	%>
	<table border="1" cellpadding="0" cellspacing="5">
		<tr>
			<th>Num</th>
			<th>Name</th>
			<th>Rate</th>
			<th>Sale</th>
		</tr>
		<tr>
			<td><%=bankBookDTO.getBookNum()%></td>
			<td><%=bankBookDTO.getBookName()%></td>
			<td><%=bankBookDTO.getBookRate()%></td>
			<td>
				<%
				if (bankBookDTO.getBookSale() == 1)
				{
				%>
				판매 중<%
				}
				else
				{
				%>
				판매 종료
				<%
				}
				%>
			</td>
		</tr>
	</table>
	<%
	}
	else
	{
	%>
	<h3>데이터가 존재하지 않습니다.</h3>
	<%
	}
	%>

	<form action="/detail" method="post">
		<h3>detail</h3>
		<a href="./bankBook/list">BankBook List</a>
		<br>
		<a href="/test_index.html>">Index Page</a>
		<br>
		<!-- 상대경로 -->
		<a href="./member/Login">Login</a>
		<!-- 절대경로 -->
		<a href="/member/Join">Join</a>
		<br>
		<a href="./list">리스트보기</a>
	</form>
</body>
</html>