<%@page import="com.naver.start.bankBook.BankBookDTO" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
			<!DOCTYPE html>
			<html>
			<style>
				.align-center {
					text-align: center;
				}
			</style>

			<head>
				<meta charset="UTF-8">
				<title>Insert title here</title>
			</head>
			<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
				integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
				crossorigin="anonymous">

			<body>
				<c:import url="../template/header.jsp"></c:import>
				<section class="container-fluid col-lg-6">
					<br>
					<h3>detail Page</h3>
					<table class="table table-hover">
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
						</tr>
					</table>
					<!-- Comment -->
					<div class="row">
						<div class="mb-3">
							<label for="writer" class="form-label">Writer</label>
							<input type="text" class="form-control" id="writer">
						</div>
						<div class="mb-3">
							<label for="contents" class="form-label">Write Contents</label>
							<textarea class="form-control" id="contents" rows="3"></textarea>
						</div>
						<div class="mb-3">
							<button type="button" id="btn" data-booknum="${dto.bookNum}"
								class="btn btn-primary">Reply</button>
						</div>
					</div>
					<!-- Comment -->
					<!-- Comment List DB에서 값 가져오기 -->
					<div>
						<section class="container-fluid col-lg-12">
							<table class="table table-hover" id="commentList">
								<thead>
									<tr>
										<th>contents</th>
										<th>writer</th>
										<th>regDate</th>
										<th>update click</th>
										<th>delete click</th>
									</tr>
								</thead>
							</table>
						</section>
					</div>
					<button class="btn btn-danger" id="more">More</button>
					<!-- Comment List -->
				</section>
				<!-- --------------------- modal --------------------- -->
				<button type="button" style="display: none;" id="up" class="btn btn-primary" data-bs-toggle="modal"
					data-bs-target="#exampleModal" data-bs-whatever="@getbootstrap">Update Click</button>

				<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Update</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">
								<form>
									<input type="hidden" id="num">
									<div class="mb-3">
										<label for="recipient-name" class="col-form-label">Writer:</label>
										<input type="text" class="form-control" id="updateWriter" disabled>
									</div>
									<div class="mb-3">
										<label for="message-text" class="col-form-label">Comment:</label>
										<textarea class="form-control" id="updateContents"></textarea>
									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
								<button type="button" id="update" class="btn btn-primary" data-bs-dismiss="modal">Update Contents</button>
							</div>
						</div>
					</div>
				</div>

				<!-- ------------------------------------------------------------------------------------------------------ -->
				<form action="" method="post" align="center">
					<div class="align-center">
						<a href="./list.naver">List Page</a>
						<br>
						<a href="../">Home Page</a>
						<br>
						<a href="./modify.naver?bookNum=${dto.bookNum }">Modify Page</a>
						<a href="./delete.naver?bookNum=${dto.bookNum}">Delete Page</a>
						<br>
						<!-- 로그인 되있는 사람만 보이게 하기 -->
						<c:if test="${member != null}">
							<a href="../account/add.naver?bookNum=${dto.bookNum }">Account Add</a>
						</c:if>
					</div>
				</form>

				<c:import url="../template/footer.jsp"></c:import>
			</body>
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
				crossorigin="anonymous"></script>
			<script src="/resources/js/bankbookComment.js"></script>

			</html>