<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="../js/jquery-2.2.4.js"></script>
<script type="text/javascript" src="../js/date.js"></script>
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
				}else{
					var cell1 = $("<p></p2>").text("您篩選的條件查無結果，請更改搜尋的條件");
					flag.append(cell1);
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
					}else{
						var cell1 = $("<p></p2>").text("您篩選的條件查無結果，請更改搜尋的條件");
						flag.append(cell1);
						showArticles.append(flag);
					}
					
				}
			})
		}
	});
</script>
<body>
	<h4>${user.name},Hello!!</h4>
	<label>討論區：</label>
	<select id="forums">
		<option value="-1">未選擇</option>
	</select>
	<label>發佈時間：</label>
	<select id="year">
		<option value="-1">未選擇</option>
	</select>
	<label>年</label>
	<select id="month">
		<option value="-1">未選擇</option>
	</select>
	<label>月</label>
	<select id=day>
		<option value="-1">未選擇</option>
	</select>
	<label>日</label>
	<table>
	</table>
	<table id="showArticles">
	</table>

</body>
</html>