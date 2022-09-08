<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
		</head>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
			integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
		<style>
			.b {
				margin-top: 10px;
			}

			.dd {
				float: left;
			}

			.dda {
				float: right;
				margin-top: 10px;
			}
		</style>

		<body>
			<c:import url="../template/header.jsp"></c:import>
			<section class="container-fluid col-lg-6 b">
				<form action="./list.naver">
					<table class="table table-hover">
						<h1>${board}_List_Page</h1>

						<div class="col-6 dd">
							<label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
							<select name="kind" class="form-select" id="inlineFormSelectPref">
								<option class="kinds" value="title">Title</option>
								<option class="kinds" value="contents">Contents</option>
								<option class="kinds" value="writer">Writer</option>
							</select>
						</div>
						<div class="col-6 dd">
							<div class="input-group">
								<input type="text" name="search" value="${param.search}" class="form-control"
									id="inlineFormInputGroupUsername" placeholder="Input Word">
							</div>
						</div>

						<div class="dda">
							<button type="submit" class="btn btn-primary">Search</button>
						</div>

						<thead>
							<tr>
								<th>Num</th>
								<th>Title</th>
								<th>Writer</th>
								<th>Date</th>
								<th>Hit</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list }" var="dto">
								<tr>
									<td>${dto.num }</td>
									<td>
										<c:catch>
											<c:forEach begin="1" end="${dto.depth}">--</c:forEach>
										</c:catch>
										<a href="./detail.naver?num=${dto.num}">${dto.title}</a>
									</td>
									<td>${dto.writer }</td>
									<td>${dto.regDate }</td>
									<td>${dto.hit }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form>

				<button onclick="location='add.naver'" type="submit" class="btn btn-primary">Writing Page</button>

			</section>
			<section class="container-fluid col-lg-6">
				<form class="col-lg-6 container-fluid page">
					<!-- --------------- page --------------- -->
					<nav aria-label="Page navigation example" class="col-lg-6 b">
						<ul class="pagination">

							<!-- page가 1번일때 이전 버튼을 없앰 -->
							<li class="page-item ${pager.pre?'':'disabled'}">
								<a class="page-link" href="./list.naver?page=${pager.startNum - 1}"
									aria-label="Previous">
									<span aria-hidden="true">&laquo;</span>
								</a>
							</li>

							<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
								<li class="page-item">
									<a class="page-link"
										href="./list.naver?page=${i}&kind${pager.kind}&search=${pager.search}">${i} </a>
								</li>
							</c:forEach>

							<c:choose>
								<c:when test="${pager.next}">
									<li class="page-item">
										<a class="page-link"
											href="./list.naver?page=${pager.lastNum + 1}&kind${pager.kind}&search=${pager.search}"
											aria-label="Next">
											<span aria-hidden="true">&raquo;</span>
										</a>
									</li>
								</c:when>
								<c:otherwise>
									<li class="page-item disabled">
										<a class="page-link"
											href="./list.naver?page=${pager.lastNum + 1}&kind${pager.kind}&search=${pager.search}"
											aria-label="Next">
											<span aria-hidden="true">&raquo;</span>
										</a>
									</li>
								</c:otherwise>
							</c:choose>
						</ul>
					</nav>
				</form>
			</section>
			<c:import url="../template/footer.jsp"></c:import>
		</body>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
			crossorigin="anonymous"></script>
		<script src="/resources/js/board.js"></script>
		<script>
			let k = '${param.kind}'; // title, contents, writer...
			// 파라미터 값과 옵션의 값을 비교해 같은 것을 selected를 준다
			const kinds = document.getElementsByClassName("kinds");

			for (let i = 0; i < kinds.length; i++) {
				if (kinds[i].value == k) {
					kinds[i].selected = true;
					break;
				}
			}
		</script>

		</html>