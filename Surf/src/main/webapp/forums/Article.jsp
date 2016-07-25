<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="header.jsp" />
<div class="page-top">
    <div class="container">
        
        
        <c:if test="${empty ArticlesMng}">
        	<c:if test="${empty TrackMng}">
				<h1 class="big-title"> ${forum.title} </h1>
	        	<div class="path">
	            	<a href="#">首頁</a> /
	            	<a href="forums.jsp">討論區</a> /
	            	<c:if test="${empty article}">
	            		<a href="DisplayPageArticles?pageNo=1">${forum.title}</a> /
	            	</c:if>
	            	<c:if test="${not empty article}">
	            		<a href="DisplayPageArticles?pageNo=1">${article.forumVO.title}</a>/
	            		${article.title} 
	            	</c:if>
	        	</div>
        	</c:if>
        	<c:if test="${not empty TrackMng}">
	        	<h1 class="big-title">文章追蹤</h1>
		        <div class="path">
		            <a href="#">首頁</a> /
		            <a href="forums.jsp">討論區</a> /
		            <a href="TrackArticlesMng.jsp">文章追蹤</a> /
		            ${article.title} 
		        </div>
	        </c:if>
		</c:if>
			
		<c:if test="${not empty ArticlesMng}">
			<h1 class="big-title">文章管理</h1>
        	<div class="path">
            	<a href="#">首頁</a> /
            	<a href="forums.jsp">討論區</a> /
            	<a href="ArticlesMng.jsp">文章管理</a> /
            	${article.title} 
        	</div>
		</c:if>
        
        
    </div>
</div>

<!-- main -->
<div id="main">
	<div class="container article-dt-wrap">

<!--         <script type="text/javascript" src="js/jquery-2.2.4.js"></script> -->
<!--         <script src="vendor/bootstrap/js/bootstrap.min.js"></script> -->
		<script type="text/javascript">
		    jQuery(function($){
		    	$('#leaveMessage').on('click', '.author', function(event) {
	            	
	            	var a=$('<p><p/>').text("aaaaa");
	            	event.append(a);
	            });
		    	
		    	
		    	
		        var articleNo=document.getElementById("article").innerHTML;
		        var memberNo = eval("${user.memberno}");
		        $.ajax({
		            type:"get",
		            url:"/Surf/Service/forums/trackEvent/trackJudge",
		            dataType:"text",
		            data:{memberNo:"${user.memberno}",articleNo:articleNo},
		            success:function(data){
		                if(data=='true'){
		                    $('#trackButton').removeClass("btn btn-success").addClass("btn btn-danger").text("取消追蹤");
		                    
		                }else{
		                    $('#trackButton').removeClass("btn btn-danger").addClass("btn btn-success").text("追蹤");
		                }
		                
		            }
		        })
		        $.ajax({
		                type:"post",
		                url:"/Surf/Service/forums/trackEvent/reportJudge",
		                dataType:"text",
		                data:{memberNo:"${user.memberno}",articleNo:articleNo},
		                success:function(data){
		                    if(data=='true'){
		                    	$('#reportButton').text("已檢舉").attr('data-target','#');
		                    }else{
		                    	$('#reportButton').text("檢舉");
		                    }
		                      
		                }
		            })
		        
		        
		        $('#trackButton').click(function(){
		            var articleNo=document.getElementById("article").innerHTML;
		            var memberNo = eval("${user.memberno}");
		            $.ajax({
		                type:"post",
		                url:"/Surf/Service/forums/trackEvent/track",
		                dataType:"text",
		                data:{memberNo:memberNo,articleNo:articleNo},
		                success:function(data){
		                    if(data=='true'){
		                        $('#trackButton').removeClass("btn btn-danger").addClass("btn btn-success").text("追蹤");
		                    }else{
		                        $('#trackButton').removeClass("btn btn-success").addClass("btn btn-danger").text("取消追蹤");
		                    }
		                    
		                }
		            })
		            
		        })
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
		                    var dl=$('<dl></dl>').attr("class","dl-horizontal");
		                    
		                    var dt=$('<dt></dt>')
		                    var a=$('<a></a>').attr("href","#").attr("class","author");
		                    var img=$('<img/>').attr("src","${pageContext.servletContext.contextPath}/Service/forums/getMemberPhoto/${user.memberno}");
		                    img.attr('class','img-circle');
		                    
		                    a.append(img);
		                    dt.append(a);
		                    
		                    
		                    var dd=$('<dd></dd>')
		                    var small=$('<small></small>').attr('class','text-muted');
		                    var a2=$('<a></a>').attr('href','#').attr('class','author');
		                    var span=$('<span></span>').attr('class','name').text(reply.MemberName);
		                    var date=$('<span></span>').attr('class','date');
		                    var i=$('<i></i>').attr('class','fa fa-calendar').text(reply.DateTime);
		                    var con=$('<div></div>').attr('class','con').text(reply.Content);
		                    
		                    
		                    a2.append(span);
		                    small.append(a2);
		                    
		                    date.append(i)
		                    small.append(date)
		                    
		                    dd.append(small); dd.append(con)
		                    
		                    dl.append(dt);
		                    dl.append(dd);
		                    
		                    flag.append(dl);      
		                })
		                leaveMessage.prepend(flag);
		            }
		        })
		        })			
				var loadTimes=2;
				
		        $('#img1').hide();
				$('#moreMsg').click(function(){
					var moreMsgDiv=$('#moreMsgDiv');
		            $.ajax({
		                type:"post",
		                url:"article.do",
		                dataType:"json",
		                data:{loadTimes:loadTimes,No:articleNo},
		                beforeSend:function(){ $('#img1').show(500)},
		                
		                success:function(datas){
		                	loadTimes++;  
		                	var flag = $(document.createDocumentFragment());
		                	var replyStatus;
		                	$.each(datas,function(idx,reply){
		                		replyStatus=reply.replyStatus;
			                    var dl=$('<dl hidden="hidden"></dl>').attr("class","dl-horizontal");
			                    
			                    var dt=$('<dt></dt>')
			                    var div=$('<div></div>').attr("class","figure-box inline").append(dt);
			                    var a=$('<a></a>').attr("href","#").attr("class","author");
			                    var img=$('<img/>').attr("src","${pageContext.servletContext.contextPath}/Service/forums/getMemberPhoto/"+reply.MemberNo);
			                   
			                    img.attr('class','img-circle');
			                    
			                    a.append(img);
			                    dt.append(a);
			                    
			                    
			                    var dd=$('<dd></dd>')
			                    var small=$('<small></small>').attr('class','text-muted');
			                    var a2=$('<a></a>').attr('href','#').attr('class','author');
			                    var span=$('<span></span>').attr('class','name').text(reply.MemberName);
			                    var date=$('<span></span>').attr('class','date');
			                    var i=$('<i></i>').attr('class','fa fa-calendar').text(reply.DateTime);
			                    var con=$('<div></div>').attr('class','con').text(reply.Content);
			                    
			                    
			                    a2.append(span);
			                    small.append(a2);
			                    
			                    date.append(i)
			                    small.append(date)
			                    
			                    dd.append(small); dd.append(con)
			                    
			                    dl.append(dt);
			                    dl.append(dd);
			                    
			                    flag.append(dl); 
			                    
			                }) 
		                	$('#moreMsgDiv').before(flag);
// 		                	$('#moreMsgDiv').before(flag).delay(2000);
// 							$("#moreMsgDiv").delay(500).queue(function() { $(this).before(flag);});
							if(parseInt(replyStatus)==-1){
								$('#img1').hide(50);
								$('#moreMsg').remove();
							}else{
								$('#img1').hide(500);
							}
		                	$('dl').fadeIn(500);
		                }
		            })
				})	
				$(document).unbind(document);
				$('#sendReportButton').click(function(){
					var articleNo=document.getElementById("article").innerHTML;
					var reportContent=$('#reportArea').val();
					$.ajax({
		                type:"post",
		                url:"/Surf/Service/forums/trackEvent/reportInsert",
		                dataType:"text",
		                data:{memberNo:"${user.memberno}",articleNo:articleNo,reasno:reportContent},
		                success:function(data){
		                    if(data=='true'){
		                        $('#reportButton').text("已檢舉").attr('data-target','#');
		                    }     
		                }
		            })
				})
		    });
		</script>
        <ul class="article-ls">
            <li class="item">
            
            	<div class="ED-wrap">
                    <a href="javascript:;" id="trackButton" class="track"></a>
                    <a href="javascript:;" id="reportButton" class="report btn btn-danger" data-backdrop="static" data-toggle="modal" data-target="#modal-report">檢舉</a>
                </div>
                
                <!-- report modal start -->
                <div class="modal fade" id="modal-report" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
				    <div class="modal-dialog modal-sm">
				        <div class="modal-content">
				            <div class="modal-header">
				                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				                <h4 class="modal-title" id="myModalLabel">檢舉這則文章</h4>
				            </div>
				            <div class="modal-body">
				                <textarea name="reportArea" id="reportArea" cols="30" rows="10"></textarea>
				            </div>
				            <div class="modal-footer">
				                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				                <input id="sendReportButton" type="button" value="Submit" class="btn btn-primary" data-dismiss="modal">
				            </div>
				        </div>
				    </div>
				</div>
				<!-- report modal end -->
                
                <h3 class="title">${article.title}</h3> 
                <small class="text-muted">
                	<a href="#" class="author">
                    	<img src="/Surf/Service/forums/getMemberPhoto/${article.memberVO.memberno}" class="img-circle">
                    	<span class="name">${article.memberVO.name}</span>
                    </a>	
                    <span class="date"><i class="fa fa-calendar"></i> ${article.datetime}</span>
                    <span class="reply"><i class="fa fa-commenting-o"></i> ${replayCount}</span>
                </small>
                <hr>
                <div class="article-content fck">
                    ${article.context}
                </div>
                <hr>

                <!-- Comments Form -->
                <div class="well" id="well">
                    <p id="article">${article.articleno}</p>
                    <h4>${user.name}:</h4>
                    
                        <div class="form-group">
                            <textarea id="replyArea" name="replyArea" class="form-control" rows="3"></textarea>
                        </div>
                        <button type="submit" id="submit" class="btn btn-primary">Submit</button>
                    
                </div>

                <div class="reply-wrap" id="leaveMessage">
					<c:forEach var="replay" items="${replayList}">
						<dl class="dl-horizontal">
						<div class="figure-box inline">
							<dt>
								<a href="#" class="author"> <img
									src="/Surf/Service/forums/getMemberPhoto/${replay.memberVO.memberno}"
									class="img-circle">
								</a>
							</dt>
								
							</div>
							<dd>
	                            <small class="text-muted">
	                                <a href="#" class="author">
	                                    <span class="name">${replay.memberVO.name}</span>
	                                </a>    
	                                <span class="date"><i class="fa fa-calendar"></i> ${replay.date}</span>
	                            </small>
	                            <div class="con">${replay.context}</div>
	                        </dd>
	                    </dl>
                    </c:forEach>
					<c:if test="${replaySumCount>=5}">
						<div id="moreMsgDiv">
							<div class="con">
								<a id="moreMsg" href="javascript:;">載入更多</a><img id="img1"
									src="img/loading.gif" class="responsive"
									style="max-width: 25px; max-heigh: 25px;" />
							</div>
						</div>
						<div class="con">
								<a href="#well">留言...</a>
						</div>
					</c:if>
				</div>
            </li>
        </ul>
    </div>  
</div>
<jsp:include page="footer.jsp" />