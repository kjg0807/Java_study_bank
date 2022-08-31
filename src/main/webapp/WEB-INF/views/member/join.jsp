<%@page import="com.naver.start.bankMember.BankMembersDTO" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="UTF-8">
				<title>회원가입</title>
				<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
					integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
					crossorigin="anonymous">
				<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
					integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
					crossorigin="anonymous"></script>
			</head>
			<style>
				form {
					margin-top: 50px;
					text-align: center;
				}
			</style>

			<body>
				<c:import url="../template/header.jsp"></c:import>

				<form action="./join.naver" method="post" enctype="multipart/form-data" id="frm">
					<h1>Join Page</h1>
					<section class="col-lg-6 container-fluid mt-4">
						<div class="row">
							<!-- id -->
							<div class="mb-3">
								<label class="form-label">ID</label>
								<input type="text" class="form-control" name="userid" aria-describedby="emailHelp"
									id="id" placeholder="ID Input" onfocus="this.placeholder=''"
									onblur="this.placeholder='ID Input'">
								<!-- id를 입력하고 나왔을 때 2글자 미만이면 메세지 출력 : id는 2글자 이상 -->
								<div id="idText" style="display: none; color: red;">ID는 2글자 이상 입력해야 합니다.</div>
							</div>
							<!-- password 1 -->
							<div class="mb-3">
								<label class="form-label">Password</label>
								<input type="password" class="form-control" name="pwd" placeholder="Password Input"
									id="pwd" onfocus="this.placeholder=''" onblur="this.placeholder='Password Input'">
								<!-- pwd를 입력할 때마다 (1글자씩) 메세지를 출력 : pwd - 최소 6글자 이상 -->
								<div id="pwdText" style="display: none; color: red;">PWD는 6글자 이상 입력해야 합니다.</div>
							</div>
							<!-- password 2 -->
							<div class="mb-3">
								<label class="form-label">Password</label>
								<input type="password" class="form-control" name="pwd" placeholder="Password Input"
									id="pwd2" onfocus="this.placeholder=''" onblur="this.placeholder='Password Input'">
								<!-- pwd를 입력하고 나왔을 때 첫번째 pwd와 값 비교 후 메세지 출력 : 같다, 다르다 -->
								<div id="pwdText2" style="display: none; color: red;">PWD가 일치하지 않습니다.</div>
							</div>
							<!-- name -->
							<div class="mb-3">
								<label class="form-label">Name</label>
								<input type="text" class="form-control" name="name" aria-describedby="emailHelp"
									id="name" placeholder="Name Input" onfocus="this.placeholder=''"
									onblur="this.placeholder='Name Input'">
								<!-- 입력 후 최소 1글자 이상 -->
								<div id="nameText" style="display: none; color: red;">최소 1글자를 입력하세요.</div>
							</div>
							<!-- email -->
							<div class="mb-3">
								<label class="form-label">Email</label>
								<input type="email" required class="form-control" name="email" aria-describedby="emailHelp"
									id="email" placeholder="Eamil Input" onfocus="this.placeholder=''"
									onblur="this.placeholder='Eamil Input'">
								<!-- 입력 후 최소 1글자 이상 -->
								<div id="emailText11" style="display: none; color: red;">이메일 형식에 맞게 입력하세요.</div>
								<div id="emailText" style="display: none; color: red;">최소 1글자를 입력하세요.</div>
							</div>
							<!-- phone -->
							<div class="mb-3">
								<label class="form-label">Phone</label>
								<input type="text" class="form-control" name="phone" aria-describedby="emailHelp"
									id="phone" placeholder="Phone Input" onfocus="this.placeholder=''"
									onblur="this.placeholder='Phone Input'">
								<!-- 입력 후 최소 1글자 이상 -->
								<div id="phoneText" style="display: none; color: red;">최소 1글자를 입력하세요.</div>
							</div>
							<!-- file -->
							<div class="mb-3">
								<label for="files" class="form-label">Image</label>
								<input type="file" class="form-control" id="files" name="photo">
								<div></div>
							</div>
							<!-- id, pwd, name, email, phone의 각 조건을 검사 후 조건이 맞을때만 회원가입 -->
							<div>
								<button type="button" id="btn" class="btn btn-primary">Sign Up</button>
								<button type="reset" class="btn btn-primary">Reset</button>
							</div>
						</div>
						<div class="row">
							<div class="mb-3 a">
								<a href="https://youtube.com">
									<img src="/resources/image/you.png">
								</a>
							</div>
						</div>
					</section>
				</form>
				<c:import url="../template/footer.jsp"></c:import>
				<script src="/resources/js/join.js"></script>
			</body>

			</html>