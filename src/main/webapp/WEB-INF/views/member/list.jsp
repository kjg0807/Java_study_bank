<%@page import="java.util.ArrayList"%>
<%@page import="com.naver.start.bankMember.BankMembersDTO"%>
<%@page import="com.naver.start.bankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- HTML반복문 사용하기 위한 선언 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
//ArrayList<BankMembersDTO> ar = (ArrayList<BankMembersDTO>) request.getAttribute("list");
%>
<body>
	<table>
		<h1>Member List Page</h1>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach begin="0" end="10" var="i" step="2">
				<!-- var: 변수명 step: 2개씩 건너뜀 -->
				<!-- for(int i = 0; i<10; i++) -->
				<!-- <h3>${pageScope.i }</h3>  -->
			</c:forEach>
			<!-- Scope 생략가능 -->
			<c:forEach items="${requestScope.list }" var="dto">
				<!-- items="${list }" - arrayList 꺼냄 -->
				<!-- memberController의 list에서 하나 꺼냄 -->
				<tr>
					<td>${pageScope.dto.userid }</td>
					<td>${pageScope.dto.name }</td>
					<td>${pageScope.dto.email }</td>
					<td>${pageScope.dto.phone }</td>
					<!-- bankMembersDTO를 꺼냄 -->
				</tr>
			</c:forEach>
			<%-- <%
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
			%> --%>
		</tbody>
	</table>
</body>
</html>