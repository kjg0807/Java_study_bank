<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Modify Page</h1>
	<form action="./modify" method="post">
		<table>
			<div>
				<tr>
					<td>Number -- </td>
					<td>
						<p>
							<b>${dto.bookNum }</b>
						</p>
					</td>
				</tr>
				<tr>
					<td>
						<input type="hidden" name="bookNum" value="${dto.bookNum }" >
					</td>
				</tr>
				<tr>
					<td>Name</td>
					<td>
						<input type="text" name="bookName" value="${dto.bookName }">
					</td>
				</tr>
			</div>
			<div>
				<tr>
					<td>Rate</td>
					<td>
						<input type="text" name="bookRate" value="${dto.bookRate }">
					</td>
				</tr>
			</div>
			<div>
				<tr>
					<td>
						<input type="submit" value="수정">
					<td>
				</tr>
			</div>
		</table>
		<br>
		<a href="./list">List Page</a>
		<br>
		<a href="../">Home Page</a>
	</form>
</body>
</html>