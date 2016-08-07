<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form enctype="multipart/form-data" method="POST" action="<c:url value='createForum.do' />"  id="createForum.do">
		<label >討論區名稱：</label>
		<input type="text" name="forumTitle" value="${param.forumTitle}" style="width: 180px;"><br>
		<font color="red" size="-1">${MsgMap.errForumTitle}</font><br>
		<label >Icon：</label>
      	<Input Type="file" name="forumPic" size="40" style="width: 480px"  ><br>
      	<font color="red" size="-1">${MsgMap.errPicture}</font><br>      	
        <input type="submit" name="submit" id="submit" value="儲存"/>
        <input type="reset" name="cancel" id="cancel" value="重填">
      <br/>
	</form>
</body>
</html>