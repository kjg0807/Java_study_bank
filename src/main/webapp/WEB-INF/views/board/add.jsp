<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- jquery -->
<script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- include summernote css/js-->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<!-- bootStrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-6">
		<h1>${board}_Add_Page</h1>
		<form action="./add.naver" method="post" enctype="multipart/form-data">
			<table class="table table-hover">
				<!-- title -->
				<div class="mb-3">
					<label>Title</label>
					<input type="text" class="form-control" name="title" id="title" aria-describedby="emailHelp" placeholder="Title Input">
					<div class="form-text">Input Title</div>
				</div>
				<!-- writer -->
				<div class="mb-3">
					<label>Writer</label>
					<input type="text" class="form-control" name="writer" id="writer" aria-describedby="emailHelp" placeholder="Writer Input">
					<div class="form-text">Input Writer</div>
				</div>
				<!-- contents -->
				<div class="mb-3">
					<label for="contents">Contents</label>
					<textarea rows="5" cols="20" class="form-control" id="contents" name="contents" placeholder="Contents Input"></textarea>
					<!-- <input type="text" class="form-control" name="writer" aria-describedby="emailHelp"> -->
					<div class="form-text">Input Contents</div>
				</div>
				<!-- files -->
				<!-- <div class="mb-3">
					<label for="files">File1</label>
					<input type="file" class="form-control" name="files" id="files">
				</div> -->				
				<div id="addFiles" name="divName">
					<button type="button" class="btn btn-primary" id="fileAdd">File Add</button>
				</div>
			</table>
			<button type="submit" class="btn btn-primary">Writing</button>
		</form>
	</section>
	<script src="/resources/js/boardAdd.js"></script>
	<script type="text/javascript">
		$("contents").summernote();
	</script>
	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>