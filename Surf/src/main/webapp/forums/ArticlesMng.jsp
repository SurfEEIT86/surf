<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="header.jsp" />
<div class="page-top">
    <div class="container">
        <h1 class="big-title"> 文章管理 </h1>
        <div class="path">
            <a href="#">首頁</a> /
            <a href="forums.jsp">討論區</a> /
            <span>文章管理</span>
        </div>
    </div>
</div>

<!-- main -->
    <script type="text/javascript" src="js/jquery-2.2.4.js"></script>
    <script type="text/javascript" src="js/date.js"></script>
    <script type="text/javascript">
        $(function() {
            $.ajax({
                type : "get",
                url : "MemberMng",
                dataType : "json",
                data : {year:"-1",mon:"-1",day:"-1",memberNo:'${user.memberno}',forumNo :'-1'},
                success : function(datas) {
                    var showArticles = $('#showArticles');
                    var flag = $(document.createDocumentFragment());
                    if (datas.length != 0) {
                        showArticles.children().remove();
                        var tr1=$('<tr></tr>').attr("class","head");
                        var th1=$('<th></th>').text("序號");
                        var th2=$('<th></th>').text("文章標題");
                        var th3=$('<th></th>').text("本日發佈");
                        var th4=$('<th></th>').text("回應數");
                        var th5=$('<th></th>').text("討論區");
                        var th6=$('<th></th>').text("操作");
                        tr1.append([th1,th2,th3,th4,th5,th6])
                        flag.append(tr1);
                        $.each(datas, function(idx, article) {
                            var tr2 = $("<tr></tr>").attr("id",article.ArticleNo+"tr2");
                            var cell1 = $("<td></td>").text(idx + 1);
                            
                            var cell2 = $("<td></td>");
                            var title=$('<a></a>').attr('href','article.do?No='+article.ArticleNo+'&ArticlesMng=1').text(article.Title);
                            cell2.append(title);
                            
                            var cell3 = $("<td></td>");
                            var i3=$("<i></i>").attr("class","fa fa-calendar");
                            cell3.append(i3).append(article.Date);
                            
                            /*等等要加controller裡面要加東西*/
                            var cell4 = $("<td></td>");
                            var i4=$("<i></i>").attr("class","fa fa-commenting-o");
                            cell4.append(i4).append(article.ReplysCount);
                            /*等等要加controller裡面要加東西*/
                            var cell5 = $("<td></td>");
                            var i5=$("<i></i>").attr("class","fa fa-tag");
                            var forumTitle=$('<a></a>').attr('href','DisplayPageArticles?forumNo='+article.ForumNo).text(article.ForumTitle);
                            cell5.append([i5,forumTitle])                            
                            
                            var cell6 = $("<td></td>");
                            /*要在增家修改刪除功能*/
                            var a6_1=$('<a></a>').attr('href','UpdateArticle?UpdateNo='+article.ArticleNo);
                            var a6_2=$('<a></a>').attr("data-target","#myModal").attr("data-toggle","modal");
                            var i6_1=$("<i></i>").attr("class","fa fa-pencil");
                            var i6_2=$("<i></i>").attr("class","fa fa-trash-o").attr("id",article.ArticleNo);
                            a6_1.append(i6_1);
                            a6_2.append(i6_2);
                            cell6.append([a6_1,a6_2]);
                            
                            tr2.append([cell1,cell2,cell3,cell4,cell5,cell6]);
                            

                            flag.append(tr2);

                        })
                        showArticles.append(flag);
                    }
                }
            })
            $.ajax({
                type : "get",
                url : "GetAllForums",
                dataType : "json",
                success : function(datas) {
                    var forums = $('#forums');
                    var forumsOpt = $(document.createDocumentFragment());
                    $.each(datas, function(idx, forums) {
                        var forumopt = $("<option></option>").text(forums.Title)
                                .attr("value", forums.ForumNo);
                        forumsOpt.append(forumopt);

                    })
                    forums.append(forumsOpt);
                }
            })
            $('#forums').change(getArtilces);
            $('#year').change(getArtilces);
            $('#month').change(getArtilces);
            $('#day').change(getArtilces);
            function getArtilces() {
                var forumNo = $('#forums').val();
                var year = $('#year').val();
                var month = $('#month').val();
                var day = $('#day').val();
                $("#showArticles").children().remove();
                $.ajax({
                    type : "get",
                    url : "MemberMng",
                    dataType : "json",
                    data : {year:year,mon:month,day:day,memberNo:'${user.memberno}',forumNo:forumNo},
                    success : function(datas) {
                        var showArticles = $('#showArticles');
                        var flag = $(document.createDocumentFragment());
                        if (datas.length != 0) {
                            showArticles.children().remove();
                            var tr1=$('<tr></tr>').attr("class","head");
                            var th1=$('<th></th>').text("序號");
                            var th2=$('<th></th>').text("文章標題");
                            var th3=$('<th></th>').text("發佈日期");
                            var th4=$('<th></th>').text("回應數");
                            var th5=$('<th></th>').text("討論區");
                            var th6=$('<th></th>').text("操作");
                            tr1.append([th1,th2,th3,th4,th5,th6])
                            flag.append(tr1);
                            $.each(datas, function(idx, article) {
                                var tr2 = $("<tr></tr>").attr("id",article.ArticleNo+"tr2");;
                                var cell1 = $("<td></td>").text(idx + 1);
                                
                                var cell2 = $("<td></td>");
                                var title=$('<a></a>').attr('href','article.do?No='+article.ArticleNo+'&ArticlesMng=1').text(article.Title);
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
                                
                                var cell6 = $("<td></td>");
                                /*要在增家修改刪除功能*/
                                var a6_1=$('<a></a>').attr('href','UpdateArticle?UpdateNo='+article.ArticleNo);
                                var a6_2=$('<a></a>').attr("data-target","#myModal").attr("data-toggle","modal");
                                var i6_1=$("<i></i>").attr("class","fa fa-pencil");
                                var i6_2=$("<i></i>").attr("class","fa fa-trash-o").attr("id",article.ArticleNo);
                                a6_1.append(i6_1);
                                a6_2.append(i6_2);
                                cell6.append([a6_1,a6_2]);
                                
                                tr2.append([cell1,cell2,cell3,cell4,cell5,cell6]);
                                

                                flag.append(tr2);

                            })
                            showArticles.append(flag);
                        }
                    }
                })

            }
            
            
            
            /*抓取動態篩選文章並刪除*/
            var id;
            $('#showArticles').on('click', '.fa-trash-o', function(event) {
            	id=event.target.id;
            });	 
    		$('#deleteButton').click(function(){
   	     	$.ajax({
   	                 type : "get",
   	                 url : "UpdateArticle",
   	                 data : {DeleteNo:id},
   	                 success : function(date) {
   	                	 if(date=="deleteOK"){
   	                		$("#"+id+"tr2").remove();
   	                	 }
   	                 }
   	         })
    	    				
    	    })
            
        });
		
        

    </script>





<div id="main">
	<div class="container member-article">

        <div class="filter clearfix">
            <div class="search pull-right">
                <select id="forums">
                    <option value="-1">未選擇</option>
                </select>
            </div>
            <div class="search pull-left">
                <select id="year">
                    <option selected="selected" value="-1">未選擇</option>
                </select>
                <select id="month">
                    <option value="-1">未選擇</option>
                </select> 
                <select id="day">
                    <option value="-1">未選擇</option>
                </select>
            </div>
            
        </div>
        
        <table class="article-ls-table" id="showArticles">
        </table>
        

		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">警告！</h4>
					</div>
					<div class="modal-body">是否確定刪除文章嗎？</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消
						</button>
						<button type="button" class="btn btn-primary" data-dismiss="modal" id="deleteButton">刪除</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
	</div>

</div>

	<jsp:include page="footer.jsp" />