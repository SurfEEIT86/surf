<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<button>檢舉文章</button>
	<table>
		<tr>
			<th><a href="forums.jsp">討論區</a></th>
			<th><a href="ForumPage?id=${article.forumVO.forumno}">${article.forumVO.title}</a></th>
		</tr>
	</table>
	<h3>${article.title}</h3>
	<p>${article.datetime}</p>
	<p>${article.memberVO.name}</p>
	<div>
		<p>${article.context}</p>
	</div>
	<script type="text/javascript" src="../js/jquery-2.2.4.js"></script>
	<script type="text/javascript">
	$(function(){
		$('#submit').click(function(){
			var content=document.getElementById("replyArea").value;
			var article=document.getElementById("article").innerHTML;
			$.ajax({
			type:"get",
			url:"LeaveMsgServlet",
			dataType:"json",
			data:{content:content,article:article},
			success:function(datas){
				var leaveMessage=$('#leaveMessage');
				var flag = $(document.createDocumentFragment());
				$.each(datas,function(idx,reply){
					$('#replyArea').val('');
					var img=$("<img/>").attr('src', "${pageContext.servletContext.contextPath}/Service/forums/getMemberPhoto/${user.memberno}");
					var cell1 = $("<p></p>").text('留言:'+reply.MemberName);
					var cell2 = $("<p></p>").text('時間:'+reply.DateTime);
					var cell3 = $("<p></p>").text('回覆:'+reply.Content);
					flag.append([img,cell1,cell2,cell3]);
				})
				leaveMessage.append(flag);
			}
		})
		})
	});
	
	</script>
	<div id="leaveMessage">
		<c:forEach var="replay" items="${replayList}">
			<img src="/Surf/Service/forums/getMemberPhoto/${replay.memberVO.memberno}">
			<p>留言:${replay.memberVO.name}</p>
			<p>時間:${replay.date}</p>
			<p>回覆:${replay.context}</p>
		</c:forEach>
	</div>
	
		<p>${user.name}:</p>
		<p id="article">${article.articleno}</p>
	<textarea cols="50" rows="5" id="replyArea" name="replyArea"></textarea>
		<button type="submit" id="submit">留言</button>
	
</body>
</html>