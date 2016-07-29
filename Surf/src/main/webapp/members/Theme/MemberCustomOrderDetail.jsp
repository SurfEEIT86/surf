<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="assets/ico/favicon.png">

<title>聚浪</title>

<!-- Bootstrap core CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="assets/css/main.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/font-awesome.min.css">

<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/Chart.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="assets/js/html5shiv.js"></script>
      <script src="assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body data-spy="scroll" data-offset="0" data-target="#theMenu">

	<!-- Menu 左邊工具列-->
	<nav class="menu" id="theMenu">
	<div class="menu-wrap">
		<h1 class="logo">
			<a href="../index.jsp">聚浪</a>
		</h1>
		<a href="#home"
			class="smoothScroll">會員首頁</a> <a href="#services"
			class="smoothScroll">個人資料</a> <a href="#about" class="smoothScroll">訊息紀錄</a>
		<a href="#contact" class="smoothScroll">訂單紀錄</a> <a
			href="../index.jsp" class="smoothScroll">回到首頁</a>
	</div>

	<!-- Menu button -->
	<div id="menuToggle">
		<i class="icon-reorder"></i>
	</div>
	</nav>



	<!-- ========== 首頁========== -->
	<section id="home" name="home"></section>
	<div id="headerwrap">
		<div class="container">
			<br>
			<h1>聚浪</h1>
			<h2>個人資料</h2>
			<div class="row">
				<br> <br> <br>
				<div class="col-lg-6 col-lg-offset-3"></div>
			</div>
		</div>
		<!-- /container -->
	</div>
	<!-- /headerwrap -->

	<!-- ========== FOOTER SECTION 訂單紀錄========== -->
	<section id="contact" name="contact">
		<div class="container">
			<h3 class="section-title">客製化訂單紀錄</h3>

			<div class="divcss5-right">

				<table border="1" width="100%" class="order-ls-table">
					<tr>
						<th>訂單編號</th>
						<th>訂單時間</th>
						<th>商品狀態</th>
						<th>總計金額</th>
					</tr>
					<tr class="toggle-dt">
						<td><fmt:formatDate value="${customorderdetail.date}" pattern="yyyyMMdd"></fmt:formatDate>C00${customorderdetail.orderno}</td>
						<td><fmt:formatDate value="${customorderdetail.date}" pattern="yyyy-MM-dd hh:mm"></fmt:formatDate></td>
						<c:if test="${customorderdetail.status==1}">
							<td>已付款</td>
						</c:if>
						<c:if test="${customorderdetail.status==2}">
							<td>已出貨</td>
						</c:if>
						<c:if test="${customorderdetail.status==3}">
							<td>已到貨</td>
						</c:if>
						<td>NT$<fmt:formatNumber value="${customorderdetail.price}" pattern="#,###,###"></fmt:formatNumber></td>
					</tr>
					<tr class="dt">
						<td colspan="4">
							<table class="order-table" width="100%">
								<tr>
									<th class="pd-name">品項</th>
									<th class="90px">材質</th>
									<th width="90px">板型</th>
									<th width="150px">尺寸</th>									
									<th width="100px">尾舵系統</th>															
								</tr>
								
									<tr>
										<td class="pd-name">
											<img src="${customorderdetail.boardpic}" />
										</td>
										<td>${customorderdetail.material}</td>
										<td>${customorderdetail.modelsvo.name}</td>
										<td>${customorderdetail.dimension}</td>
										<td>${customorderdetail.finsys}</td>																	
									</tr>
															
							</table>
						</td>
					</tr>
				</table>
				<div class="text-center">
					<a href="MemberData.jsp#contact" class="btn">回訂單列表</a>
				</div>

			</div>	
		</div>
	</section>



					<!-- Bootstrap core JavaScript
    ================================================== -->
					<!-- Placed at the end of the document so the pages load faster -->
					<script src="assets/js/classie.js"></script>
					<script src="assets/js/bootstrap.min.js"></script>
					<script src="assets/js/smoothscroll.js"></script>
					<script src="assets/js/main.js"></script>
</body>
</html>
