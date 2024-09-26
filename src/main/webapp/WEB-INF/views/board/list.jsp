<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% pageContext.setAttribute("CRLF", "\r\n"); %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시글 목록</title>
	</head>
	<body>
		<div>
			<form>
				<input type="text" name="keyword" value="${keyword}" style="width:150px;">
				<button type="submit">검색</button>
			</form>
		</div>
		<c:if test="${not empty boardList}">
			<table>
				<thead>
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>입력일시</th>
						<th>수정</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="board" items="${boardList}">
						<tr>
							<td>${board.seq}</td>
							<td><a href="${pageContext.request.contextPath}/read/${board.seq}">${board.title}</a></td>
							<td>${board.createdAt}</td>
							<td>
								<a href="${pageContext.request.contextPath}/update/${board.seq}">수정</a>
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/delete/${board.seq}">삭제</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${empty boardList}">
			<strong>게시글이 없습니다.</strong>
		</c:if>
	</body>
</html>