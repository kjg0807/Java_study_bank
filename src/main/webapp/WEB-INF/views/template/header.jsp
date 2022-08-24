<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.a {
	color: white;
}
</style>
<header class="container-fluid">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Navbar</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active" aria-current="page" href="../">Home</a></li>
					<li class="nav-item"><a class="nav-link active" href="/book/list.naver">Book List</a></li>
					<li class="nav-item"><a class="nav-link active" href="/notice/list.naver">Notice</a></li>
					<li class="nav-item"><a class="nav-link active" href="/qna/list.naver">QnA</a></li>
					<li class="nav-item"><a class="nav-link active" href="/member/search.naver">Search</a></li>

					<c:choose>
						<c:when test="${member != null }">
							<p class="a">${member.name}님안녕하세요!</p>
							<li class="c"><a class="nav-link active" href="/member/mypage.naver">My Page</a></li>
							<li class="c"><a class="nav-link active" href="/member/logout.naver">Logout</a></li>
						</c:when>
						<c:otherwise>
							<li class="c"><a class="nav-link active" href="/member/login.naver">Login</a></li>
							<li class="c"><a class="nav-link active" href="/member/join.naver">Join</a></li>
						</c:otherwise>
					</c:choose>

				</ul>
			</div>
		</div>
	</nav>
</header>