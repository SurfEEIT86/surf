<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />
<div class="page-top">
	<div class="container">
		<h1 class="big-title">${forum.title}</h1>
		<div class="path">
			<a href="../members/index.jsp">首頁</a> / <a href="forums.jsp">討論區</a> / <span>${forum.title}</span>
		</div>
	</div>
</div>

<!-- main -->
<div id="main">
	<div class="container">

		<div class="filter clearfix">
		<form action="SearchArticles">
			<div class="search pull-right">
				<select name="searchArea" id="searchArea" style="width:100px">
					<option value="1" >作者</option>
					<option value="2" selected="selected">標題</option>
				</select>
				<div class="search-ip">
					<input type="text" name ="queryString" value="${queryString}">
					<button type="submit">
						<i class="fa fa-search"></i>
					</button>
				</div>
			</div>
		</form>
			<div class="sort pull-left">
				<a href="DisplayPageArticles?pageNo=1" class="btn active">最新</a> <a href="SortArticlesbyHot?pageNo=1" class="btn">熱門</a>

				
			</div>

		</div>

		
		<ul class="article-ls">
			<p style="color:#fff;">${showSearchMsg}</p>
			<c:forEach var="article" items="${forumArticles}" varStatus="var">
				<li class="item"><a href="article.do?No=${article.articleno}"><h3
							class="title">${article.title}</h3></a> <small class="text-muted">
						<a href="#" class="author"> <img
							src="/Surf/Service/forums/getMemberPhoto/${article.memberVO.memberno}"
							class="img-circle"> <span class="name">${article.memberVO.name}</span>
					</a> <span class="date" id="date${var.index+1}"><i class="fa fa-calendar"></i>
							</span> <span class="reply"><i
							class="fa fa-commenting-o"></i> ${replyList[var.index]}</span>
				</small></li>
			</c:forEach>
		</ul>
		<script src="js/jquery.timeago.js" type="text/javascript"></script>
		<script type="text/javascript">
			$(function(){
				var index=1;
				<c:forEach items="${forumArticles}" var="article" varStatus="var">
					var a=$('#date'+index)
					index++;
					$('#date${var.index+1}').append(jQuery.timeago('${article.datetime}'))
				
				</c:forEach>
			})
		</script>
		<div class="pagi clearfix">
			<c:if test="${totalPages<=1}">
				<a href="${controller}?pageNo=${pageNo}&queryString=${queryString}&searchArea=${searchArea}" class="active">${pageNo}</a>
			</c:if>
			<c:if test="${pageNo>1}">
				<a href="${controller}?pageNo=${pageNo-1}&queryString=${queryString}&searchArea=${searchArea}" class="p-btn"><span
					class="tri">&nbsp;</span></a>
			</c:if>
			<c:if test="${pageNo<1}">
				<a href="${controller}?pageNo=1" class="p-btn"><span
					class="tri">&nbsp;</span></a>
			</c:if>
			
			<c:if test="${totalPages==2}">
			<a href="${controller}?pageNo=1&queryString=${queryString}&searchArea=${searchArea}">1</a>... 
				<c:if test="${pageNo==totalPages}">
					<a href="${controller}?pageNo=${totalPages-1}&queryString=${queryString}&searchArea=${searchArea}">${totalPages-1}</a>
					<a href="${controller}?pageNo=${totalPages}&queryString=${queryString}&searchArea=${searchArea}" class="active">${totalPages}</a>
				</c:if>
				<c:if test="${pageNo==totalPages-1}">
					<a href="${controller}?pageNo=${totalPages-1}&queryString=${queryString}&searchArea=${searchArea}" class="active">${totalPages-1}</a>
					<a href="${controller}?pageNo=${totalPages}&queryString=${queryString}&searchArea=${searchArea}">${totalPages}</a>
				</c:if>
				<c:if test="${pageNo+1<=totalPages}">
					<a href="${controller}?pageNo=${pageNo+1}&queryString=${queryString}&searchArea=${searchArea}" class="n-btn"><span
						class="tri">&nbsp;</span></a>
				</c:if>
			</c:if>
			<c:if test="${totalPages>=3}">
				<a href="${controller}?pageNo=1&queryString=${queryString}&searchArea=${searchArea}">1</a>... 
				<c:if test="${pageNo+2>totalPages}">
					<c:if test="${pageNo==totalPages}">
						<a href="${controller}?pageNo=${totalPages-2}&queryString=${queryString}&searchArea=${searchArea}">${totalPages-2}</a>
						<a href="${controller}?pageNo=${totalPages-1}&queryString=${queryString}&searchArea=${searchArea}">${totalPages-1}</a>
						<a href="${controller}?pageNo=${totalPages}&queryString=${queryString}&searchArea=${searchArea}" class="active">${totalPages}</a>
					</c:if>
					<c:if test="${pageNo==totalPages-1}">
						<a href="${controller}?pageNo=${totalPages-2}&queryString=${queryString}&searchArea=${searchArea}">${totalPages-2}</a>
						<a href="${controller}?pageNo=${totalPages-1}&queryString=${queryString}&searchArea=${searchArea}"
							class="active">${totalPages-1}</a>
						<a href="${controller}?pageNo=${totalPages}&queryString=${queryString}&searchArea=${searchArea}">${totalPages}</a>
					</c:if>
					<c:if test="${pageNo==totalPages-2}">
						<a href="${controller}?pageNo=${totalPages-2}&queryString=${queryString}&searchArea=${searchArea}"
							class="active">${totalPages-2}</a>
						<a href="${controller}?pageNo=${totalPages-1}&queryString=${queryString}&searchArea=${searchArea}">${totalPages-1}</a>
						<a href="${controller}?pageNo=${totalPages}&queryString=${queryString}&searchArea=${searchArea}">${totalPages}</a>
					</c:if>
				</c:if>
				<c:if test="${pageNo+2<=totalPages}">
					<c:if test="${pageNo==1}">
						<a href="${controller}?pageNo=${pageNo}&queryString=${queryString}&searchArea=${searchArea}" class="active">${pageNo}</a>
						<a href="${controller}?pageNo=${pageNo+1}&queryString=${queryString}&searchArea=${searchArea}">${pageNo+1}</a>
						<a href="${controller}?pageNo=${pageNo+2}&queryString=${queryString}&searchArea=${searchArea}">${pageNo+2}</a>
					</c:if>
					<c:if test="${pageNo==totalPages}">
						<a href="${controller}?pageNo=${pageNo-2}&queryString=${queryString}&searchArea=${searchArea}" >${pageNo-2}</a>
						<a href="${controller}?pageNo=${pageNo-1}&queryString=${queryString}&searchArea=${searchArea}">${pageNo-1}</a>
						<a href="${controller}?pageNo=${pageNo}&queryString=${queryString}&searchArea=${searchArea}" class="active">${pageNo}</a>
					</c:if>
					<c:if test="${pageNo!=1&&pageNo!=totalPages}">
						<a href="${controller}?pageNo=${pageNo-1}&queryString=${queryString}&searchArea=${searchArea}" >${pageNo-1}</a>
						<a href="${controller}?pageNo=${pageNo}&queryString=${queryString}&searchArea=${searchArea}" class="active">${pageNo}</a>
						<a href="${controller}?pageNo=${pageNo+1}&queryString=${queryString}&searchArea=${searchArea}" >${pageNo+1}</a>
					</c:if>
				</c:if> 
            ...
            <a href="${controller}?pageNo=${totalPages}&queryString=${queryString}&searchArea=${searchArea}">${totalPages}</a>
				<c:if test="${pageNo+1<=totalPages}">
					<a href="${controller}?pageNo=${pageNo+1}&queryString=${queryString}&searchArea=${searchArea}" class="n-btn"><span
						class="tri">&nbsp;</span></a>
				</c:if>
			</c:if>
		</div>

	</div>
</div>
<jsp:include page="footer.jsp" />
