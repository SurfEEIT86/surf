<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    <jsp:include page="header.jsp" />
    <div class="page-top">
	    <div class="container">
	        <h1 class="big-title"> 討論區 </h1>
	        <div class="path">
	            <a href="../members/index.jsp">首頁</a> /
	            <span>討論區</span>
	        </div>
	    </div>
	</div>

    <!-- main -->
    <div id="main">
        <div class="container article-ca-wrap">

            <div class="row article-ca">
                <c:forEach var="forum" items="${forums}">
                    <div class="col-sm-4 item">
                        <a href="DisplayPageArticles?forumNo=${forum.forumno}">
                            <img src="photo.do?forumNo=${forum.forumno}" width="100%">
                        </a>
                    </div> 
                </c:forEach>
            </div>
            
        </div>
    </div>
    
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
                        var thead=$('<thead></thead>');
                        var th1=$('<th></th>').text("本日發佈");
                        var th2=$('<th></th>').text("文章標題");
                        var th3=$('<th></th>').text("發佈日期");
                        var th4=$('<th></th>').text("討論區");
                        flag.append([thead,th1,th2,th3,th4]);
                        $.each(datas, function(idx, article) {
                            $("#showArticles").children().remove();
                            var cell0 = $("<tr></tr>");
                            var cell1 = $("<td></td>").text(idx + 1);
                            var cell2 = $("<td></td>").text(article.Title);
                            var cell3 = $("<td></td>").text(article.Date);
                            var cell4 = $("<td></td>").text(article.Forum);
                            var title=$('<a></a>').attr('href','article.do?No='+article.ArticleNo);
                            title.append(cell2)
                            cell0.append([ cell1, title, cell3, cell4 ]);
                            flag.append(cell0);

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
                            var thead=$('<thead></thead>');
                            
                            if((parseInt(forumNo)!=-1)||(parseInt(year)!=-1)||(parseInt(month)!=-1)||(parseInt(day)!=-1)){
                                var th1=$('<th></th>').text("篩選結果");
                            }else{
                                var th1=$('<th></th>').text("本日發佈");
                            }
                            
                            var th2=$('<th></th>').text("文章標題");
                            var th3=$('<th></th>').text("發佈日期");
                            var th4=$('<th></th>').text("討論區");
                            flag.append([thead,th1,th2,th3,th4]);
                            $.each(datas, function(idx, article) {
                                var cell0 = $("<tr></tr>");
                                var cell1 = $("<td></td>").text(idx + 1);
                                var cell2 = $("<td></td>").text(article.Title);
                                var cell3 = $("<td></td>").text(article.Date);
                                var cell4 = $("<td></td>").text(article.Forum);
                                var title=$('<a></a>').attr('href','article.do?No='+article.ArticleNo);
                                title.append(cell2)
                                cell0.append([ cell1, title, cell3, cell4 ]);
                                flag.append(cell0);
                            })
                            showArticles.append(flag);
                        }else{
                            showArticles.children().remove();
                            var cell1 = $("<p></p2>").text("您篩選的條件查無結果，請更改搜尋的條件");
                            flag.append(cell1);
                            showArticles.append(flag);
                        }
                        
                    }
                })
            }
        });
    </script>
    <jsp:include page="footer.jsp" />


