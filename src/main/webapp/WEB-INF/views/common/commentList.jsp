<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<section class="container-fluid col-lg-6">
			<table class="table table-hover">
				<c:forEach items="${commentList}" var=dto>
					<tr>
						<td>${dto.contents}</td>
						<td>${dto.writer}</td>
						<td>${dto.regDate}</td>
					</tr>
				</c:forEach>
			</table>
		</section> 
		<script src="/resources/js/bankbookComment.js"></script>