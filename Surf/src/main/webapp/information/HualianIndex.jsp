<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>HualianIndex</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/small-business.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<!-- Navigation -->

	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"> <img
					src="http://placehold.it/150x50&text=Logo" alt="">
				</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="#">首頁</a></li>
					<li><a href="#">資訊索引</a></li>
					<li><a href="#">聯絡我們</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<!-- Page Content -->
	<div class="container">

		<!-- Heading Row -->
		<div class="row">
			<div class="col-md-8">
				<img class="img-responsive img-rounded" src="img/花蓮MAP.png" alt="">
			</div>
			<!-- /.col-md-8 -->
			<div class="col-md-4">
				<h1>花蓮浪點相關資訊</h1>

			</div>
			<!-- /.col-md-4 -->
		</div>
		<!-- /.row -->

		<hr>

		<!-- Call to Action Well -->

		<!-- /.row -->

		<!-- Content Row -->
		<div class="row">
			<div class="col-md-4">
			
				<h2>探索熱門餐廳</h2>
							<c:forEach var="ShopsVO" items="${shopList}">
						<div class="col-md-6">

							<a href="showShopData?ShopNo=${ShopsVO.shopno}"> <img
								class="img-portfolio img-responsive"
								src="ShopImg?ShopNo=${ShopsVO.shopno}">
							</a><a href='showShopData?ShopNo=${ShopsVO.shopno}'>${ShopsVO.name}</a>

						</div>
					</c:forEach>
				<img src="img/portfolio-11.jpg" alt="">

				<div class="ratings">
					<p class="pull-left">第一麵</p>
					<p class="pull-right">15 reviews</p>
					<p>
						<span class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span>
					</p>
				</div>
				<div class="ratings">
					<p class="pull-left">韓味館</p>
					<p class="pull-right">15 reviews</p>
					<p>
						<span class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span>

					</p>
				</div>
				<div class="ratings">
					<p class="pull-left">大師炒飯</p>
					<p class="pull-right">15 reviews</p>
					<p>
						<span class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span>
					</p>
				</div>
				<div class="ratings">
					<p class="pull-left">大師炒飯</p>
					<p class="pull-right">15 reviews</p>
					<p>
						<span class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span>
					</p>
				</div>
				<a class="btn btn-default" href="#">More Info</a>
			</div>
			<!-- /.col-md-4 -->
			<div class="col-md-4">
				<h2>探索熱門商家</h2>
							<c:forEach var="ShopsVO" items="${shopList}">
						<div class="col-md-6">

							<a href="showShopData?ShopNo=${ShopsVO.shopno}"> <img
								class="img-portfolio img-responsive"
								src="ShopImg?ShopNo=${ShopsVO.shopno}">
							</a><a href='showShopData?ShopNo=${ShopsVO.shopno}'>${ShopsVO.name}</a>

						</div>
					</c:forEach>
				<img src="img/shop-04.jpg" alt="">
				<div class="ratings">
					<p class="pull-left">第一麵</p>
					<p class="pull-right">15 reviews</p>
					<p>
						<span class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span>
					</p>
				</div>
				<div class="ratings">
					<p class="pull-left">韓味館</p>
					<p class="pull-right">15 reviews</p>
					<p>
						<span class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span>

					</p>
				</div>
				<div class="ratings">
					<p class="pull-left">大師炒飯</p>
					<p class="pull-right">15 reviews</p>
					<p>
						<span class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span>
					</p>
				</div>
								<div class="ratings">
					<p class="pull-left">大師炒飯</p>
					<p class="pull-right">15 reviews</p>
					<p>
						<span class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span> <span
							class="glyphicon glyphicon-star"></span>
					</p>
				</div>
				<a class="btn btn-default" href="#">More Info</a>
			</div>
			<!-- /.col-md-4 -->
			<div class="col-md-4">
				<h2>浪點潮汐預報</h2>
				<link href="//www.surf-forecast.com/stylesheets/feed.css"
					media="screen" rel="stylesheet" type="text/css" />
				<div id="wf-weatherfeed">
					<iframe style="overflow: hidden; border: none;"
						allowtransparency="true" height="272" width="469"
						src="//www.surf-forecast.com/breaks/Barrels/forecasts/feed/a"
						scrolling="no" frameborder="0" marginwidth="0" marginheight="0">
						<p>Your browser does not support iframes.</p>
					</iframe>
					<div id="wf-link">
						<a href="http://www.surf-forecast.com/"><img
							alt="Surf Forecast"
							src="//www.surf-forecast.com/images/feed/surflogo-150.jpg" /></a>
						<p id="cmt">
							More <a href="//www.surf-forecast.com/breaks/Barrels">Detailed
								Surf Conditions &amp; Webcams for&nbsp;Barrels</a>
							<nobr>
								at&nbsp;<a href="//www.surf-forecast.com/">surf-forecast.com</a>
							</nobr>
							.
						</p>
						<div style="clear: both;"></div>
					</div>
				</div>
				<a class="btn btn-default" href="#">More Info</a>
			</div>
			<!-- /.col-md-4 -->
		</div>
		<!-- /.row -->

		<!-- Footer -->
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; Your Website 2014</p>
				</div>
			</div>
		</footer>

	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

</body>

</html>
