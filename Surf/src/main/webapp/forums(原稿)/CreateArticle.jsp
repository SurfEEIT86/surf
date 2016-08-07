<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ckeditor_upload.html</title>

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
<script type="text/javascript" src="../js/jquery-2.2.4.js"></script>
<script type="text/javascript" src="../js/jquery.webkitresize.js"></script>
<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
<script type="text/javascript">
	window.onload = function() {
		CKEDITOR.replace("content", {
			width : 600,
			height : 400,
			filebrowserFileUploadUrl : 'upload?type=file',  
            filebrowserImageUploadUrl : 'upload?type=image',   
            filebrowserFlashUploadUrl : 'upload?type=flash'
		});
	};
</script>
<script type="text/javascript">
	$(function(){
		$('#reset').click(function CKupdate(){
		    for ( instance in CKEDITOR.instances ){
		        CKEDITOR.instances[instance].updateElement();
		    }
		    CKEDITOR.instances[instance].setData('');
		}   )
	})
</script>

</head>

<body>
<h4>${user.name},Hello!!</h4>
<form action="<c:url value='createArticle.do' />" method="POST">
	<label>標題：</label><input type="text" name="title" style="width: 500px">
	<textarea id="content" name="articleContent"></textarea>
	<input type="submit" value="發表">
	<input type="reset" id="reset" value="清除">
</form>
<button>放棄編輯</button>
</body>
</html>