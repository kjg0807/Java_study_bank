<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Page</h1>
	<form action="./add" method="post">
		<div>
			Number :
			<input type="text" name="bookNum">
		</div>
		<div>
			Name :
			<input type="text" name="bookName">
		</div>
		<div>
			Rate :
			<input type="text" name="bookRate">
		</div>
		<div>
			Sale(0 or 1) :
			<input type="text" name="bookSale">
		</div>
		<div>
			<input type="submit" value="Create">
		</div>
	</form>
</body>
</html>