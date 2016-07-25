<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>${user.name},Hello!!</h4>
	<table>
		<tr>
		<th><a href="forums.jsp">討論區</a></th> 
		<th>一般討論區</th> 
		</tr>
		
		<tr>
		<th>標題</th>
		<th>回復</th>
		<th>作者</th>
		<th>發表日期</th>
		</tr>
	
<%-- 	<c:forEach var="reply" items="${replyList}"> --%>
<!-- 		<tr> -->
<%-- 			<td>${reply}</td> --%>
<!-- 		</tr> -->
<%-- 	</c:forEach> --%>
	
	<a href="CreateArticle.jsp"><h1>發表文章</h1></a>
	<c:forEach var="article" items="${forumArticles}" varStatus="var">
	<tr>
	<td><a href="article.do?No=${article.articleno}">${article.title}</a></td>
	<td>${replyList[var.index]}</td>
	<td>${article.memberVO.name}</td>
	<td>${article.datetime}</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>