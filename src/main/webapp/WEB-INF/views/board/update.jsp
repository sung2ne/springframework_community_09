<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% pageContext.setAttribute("CRLF", "\r\n"); %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시글 수정</title>
	</head>
	<body>
		<form method="post">
			<p>
				제목 : 
				<input type="text" name="title" style="width:80%" value="${board.title}" />
			</p>
			<p>
				본문 :  
				<textarea rows="10" name="content" style="width:100%">${board.content}</textarea>
			</p>
			<p>
				비밀번호 : 
				<input type="password" name="passwd" />
			</p>
			<p>
				<button type="submit" name="update">게시글 수정</button>
				&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/board/read/${board.seq}">수정 취소</a>
			</p>
		</form>
	</body>
</html>