<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />
<div class="page-top">
	<div class="container">

		<c:if test="${empty UpdateArticleTitle}">
			<h1 class="big-title">新增文章</h1>
		</c:if>
		<c:if test="${not empty UpdateArticleTitle}">
			<h1 class="big-title">${UpdateArticleTitle}</h1>
		</c:if>
		<div class="path">
			<a href="../members/index.jsp">首頁</a> / <a href="forums.jsp">討論區</a>/

			<c:if test="${empty ArticlesMng}">
				<c:if test="${empty article}">
					<a href="ForumPage?forumNo=${forum.forumno}">${forum.title}</a> /
            	</c:if>
				<c:if test="${not empty article}">
					<a href="ForumPage?forumNo=${article.forumVO.forumno}">${article.forumVO.title}</a>/ 
            	</c:if>
				<span>新增文章</span>
			</c:if>
			
			<c:if test="${not empty ArticlesMng}">
				<a href="ArticlesMng.jsp">文章管理</a> /
				<span>修改文章</span>
			</c:if>
		</div>
	</div>
</div>

<!-- main -->
<div id="main" class="creat-article">
	<div class="container">

		<script type="text/javascript" src="js/jquery-2.2.4.js"></script>
		<script type="text/javascript" src="js/jquery.webkitresize.js"></script>
		<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
		<script type="text/javascript">
			window.onload = function() {
				CKEDITOR.replace("content", {
					width : 1150,
					height : 400,
					filebrowserFileUploadUrl : 'upload?type=file',
					filebrowserImageUploadUrl : 'upload?type=image',
					filebrowserFlashUploadUrl : 'upload?type=flash'
				});
			};
		</script>
		<script type="text/javascript">
			$(function() {
				$('#reset').click(function CKupdate() {
					for (instance in CKEDITOR.instances) {
						CKEDITOR.instances[instance].updateElement();
					}
					CKEDITOR.instances[instance].setData('');
				})
				$('#reset').click(function() {
					$('#articleTitle').val("");
				})
			})
		</script>
		<!-- content -->
		<form
			action="<c:url value='createArticle.do?UpdateArticleNo=${UpdateArticleNo}' />"
			method="POST">
			<div class="form-group f-title">
				<label for="title" class="text">標題</label> <input type="text"
					id="articleTitle" class="form-control" name="title"
					value="${UpdateArticleTitle}">
			</div>
			<textarea id="content" name="articleContent">${UpdateArticleContent}</textarea>
			<br>
			<a href="javascript:;" class="btn btn-primary" data-backdrop="static"
				data-toggle="modal" data-target="#modal-send">送出文章</a> <a
				href="javascript:;" class="btn btn-primary" data-backdrop="static"
				data-toggle="modal" data-target="#modal-reset">清除</a>
			<!--/top story-->

			<!-- send modal start -->
			<div class="modal fade" id="modal-send" tabindex="-1" role="dialog"
				aria-labelledby="mySmallModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-sm">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="myModalLabel"></h4>
						</div>
						<div class="modal-body">
							<p>確定是否送出文章?</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
							<input type="submit" value="確定送出" class="btn btn-primary">
						</div>
					</div>
				</div>
			</div>
			<!-- send modal end -->

			<!-- reset modal start -->
			<div class="modal fade" id="modal-reset" tabindex="-1" role="dialog"
				aria-labelledby="mySmallModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-sm">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="myModalLabel"></h4>
						</div>
						<div class="modal-body">
							<p>確定是否清除文章內容?</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
							<input type="reset" id="reset" value="Reset"
								class="btn btn-primary" data-dismiss="modal">
						</div>
					</div>
				</div>
			</div>
			<!-- reset modal end -->


		</form>

	</div>
</div>


<jsp:include page="footer.jsp" />
