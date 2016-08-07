<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="header.jsp" />
	<div class="page-top">
	    <div class="container">
			<h1 class="big-title">文章追蹤</h1>
	        <div class="path">
	            <a href="../members/index.jsp">首頁</a> /
	            <a href="forums.jsp">討論區</a> /
	          	  文章追蹤
	        </div>
	    </div> 
	</div>
<script type="text/javascript" src="js/jquery-2.2.4.js"></script>	
<script type="text/javascript">
	$(function(){
		$.ajax({
            type : "get",
            url : "GetAllForums",
            dataType : "json",
            success : function(datas) {
                var forums = $('#forums');
                var forumsOpt = $(document.createDocumentFragment());
                $.each(datas, function(idx, forums) {
                    var forumopt = $("<a></a>").attr('id',forums.ForumNo).attr('class','btn').text(forums.Title)
                            .attr("value", forums.ForumNo).attr('href','javascript:;');
                    
                    forumsOpt.append(forumopt);
                   

                })
                forums.append(forumsOpt);
            }
        })
        $('#forums').on('click', 'a', function(event) {
        	var a=$(event.target);
        	a.siblings().removeClass('active');
        	a.addClass('active');
        	var id=event.target.id;
            $("#showArticles").children().remove();
            $.ajax({
                type : "get",
                url : "TrackForum",
                dataType : "json",
                data : {forumNo:id},
                success : function(datas) {
                    var showArticles = $('#showArticles');
                    var flag = $(document.createDocumentFragment());
                    if (datas.length != 0) {
                    	showArticles.children().remove();
                        var tr1=$('<tr></tr>').attr("class","head");
                        var th1=$('<th></th>').text("序號");
                        var th2=$('<th></th>').text("文章標題");
                        var th3=$('<th></th>').text("追蹤日期");
                        var th4=$('<th></th>').text("回應數");
                        var th5=$('<th></th>').text("討論區");
                        
                        tr1.append([th1,th2,th3,th4,th5])
                        flag.append(tr1);
                        $.each(datas, function(idx, article) {
                            var tr2 = $("<tr></tr>").attr("id",article.ArticleNo+"tr2");
                            var cell1 = $("<td></td>").text(idx + 1);
                            
                            var cell2 = $("<td></td>");
                            var title=$('<a></a>').attr('href','article.do?No='+article.ArticleNo+'&TrackMng=1').text(article.Title);
                            cell2.append(title);
                            
                            var cell3 = $("<td></td>");
                            var i3=$("<i></i>").attr("class","fa fa-calendar");
                            cell3.append(i3).append(article.Date);
                            
                           
                            var cell4 = $("<td></td>");
                            var i4=$("<i></i>").attr("class","fa fa-commenting-o");
                            cell4.append(i4).append(article.ReplysCount);
                       
                            var cell5 = $("<td></td>");
                            var i5=$("<i></i>").attr("class","fa fa-tag");
                            var forumTitle=$('<a></a>').attr('href','DisplayPageArticles?forumNo='+article.ForumNo).text(article.ForumTitle);
                            cell5.append([i5,forumTitle])                            
                            
                            ;
                            
                            tr2.append([cell1,cell2,cell3,cell4,cell5]);
                            

                            flag.append(tr2);

                        })
                        showArticles.append(flag);
                    }
                }
            })

        });	 
		
		
	})
</script>
	
	<!-- main -->
    <div id="main">
		<div class="container follow-wrap">
		<div id="forums" class="follow-ca">
		<a href="javascript:;" class="btn" id="allTrackArticles">全部追蹤的文章</a>
		</div>
		<table class="article-ls-table" id="showArticles">
	     </table>
		</div>
	</div>
<jsp:include page="footer.jsp" />
