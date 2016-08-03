<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="chrome=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=0">
<meta name="keywords" content="">
<meta name="description" content="">
<title>聚浪</title>
<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" >
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/custom.js"></script>
</head>

<body>

	<header>
		<div class="container">
			<a href="../members/index.jsp" class="logo">
				<img src="images/logo.svg" alt="聚浪">
				<h1>聚浪</h1>
			</a>	
		</div>
	</header>

	<section class="search-wrap search-wrap-home" style="background-image:url(images/bg.jpg)">
		<div class="container">
			<div class="td">
				<h1>尋找浪點</h1>
				<form id="search" action='SearchSitesOrCity' target="_blank"
					style="display: inline;" method="get">
					<input name="sitesearch" type="text" class="form-control" />
				</form>
			</div>
		</div>
	</section>

	<section class="home-info-ls">
		<div class="container">
			<ul class="info-list clearfix">
			<c:forEach var="siteVO" items="${sitesList}" varStatus="var">
				<li>
					<a href="SearchSitesOrCity?sitesearch=${siteVO.name}">
						<div class="img-wrap">
							<div class="td">
								<img src="SiteImg?SiteNo=${siteVO.siteno}">	
							</div>
						</div>
						<div class="text-wrap">
							<h2>${siteVO.name}</h2>
							<div class="area"> <i class="fa fa-map-marker"></i>${cityNameList[var.index]}</div>	
						</div>
					</a>
				</li>
			</c:forEach>
			</ul>
		</div>
	</section>

</body>
</html>