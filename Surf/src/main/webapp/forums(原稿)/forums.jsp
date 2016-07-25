<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-1.9.1.js"></script>
<style type="text/css">
.resize {
	width: auto;
	width: 200px;
	height: 200px;
	margin: 1em;
}
.box {
  float: left;
  width: 200px;
  height: 100px;
  margin: 1em;
}
.after-box {
  clear: left;
}
</style>
</head>
<body>
	<h4>${user.name},Hello!!</h4>
	<h1>討論區</h1>
	<a href="../index.jsp">回首頁</a>
	<c:forEach var="forum" items="${forums}">
		<div class="box">
			<img src="photo.do?forumNo=${forum.forumno}" class="resize" />
			<a href="ForumPage?forumNo=${forum.forumno}"><h3>${forum.title}</h3></a>
		</div>
	</c:forEach>
</body>
</html>